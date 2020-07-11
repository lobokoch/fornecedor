package br.com.kerubin.api.cadastros.fornecedor.foto;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Rotation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.kerubin.api.cadastros.fornecedor.entity.foto.FotoEntity;
import br.com.kerubin.api.cadastros.fornecedor.entity.foto.FotoRepository;
import br.com.kerubin.api.cadastros.fornecedor.entity.produto.ProdutoEntity;
import br.com.kerubin.api.cadastros.fornecedor.entity.produto.ProdutoLookupResult;
import br.com.kerubin.api.cadastros.fornecedor.entity.produto.ProdutoRepository;
import br.com.kerubin.api.servicecore.error.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@Service
public class ProdutoFotosServiceImpl implements ProdutoFotosService {

	@Inject
	private ProdutoRepository produtoRepository;

	@Inject
	private FotoRepository fotoRepository;

	@Transactional
	@Override
	public FotoDTO uploadProdutoFotoAndGet(UUID produtoId, MultipartFile file) {
		log.info("Receiving foto upload for productId: {}.", produtoId);

		ProdutoEntity produto = produtoRepository.getOne(produtoId);
		FotoEntity foto = new FotoEntity();
		try {
			foto.setNome(file.getOriginalFilename());

			foto.setMiniatura(compressBytes(createThumbnail(file.getInputStream(), 100, 100).toByteArray()));

			foto.setImagem(compressBytes(file.getBytes()));

			foto.setTamanho((long) foto.getImagem().length);
			foto.setTipo(file.getContentType());
			foto.setProduto(produto);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					MessageFormat.format("Erro ao atribuir arquivo: {0}, para foto em produto com id: {1}. Erro: {2}",
							file, produtoId, e.getMessage()));
		}

		try {
			foto = fotoRepository.saveAndFlush(foto);
		} catch (Exception e) {
			throw new IllegalStateException(MessageFormat.format(
					"Erro ao salvar foto: {0} em produto com id: {1}. Erro: {2}", foto, produtoId, e.getMessage()));
		}

		FotoDTO fotoDTO = fotoEntityToDTO(foto);
		return fotoDTO;
	}

	@Transactional
	@Override
	public List<UUID> produtoFotosUpload(UUID produtoId, List<MultipartFile> fotos) {
		log.info("Receiving {} images upload for productId: {}.", produtoId, fotos != null ? fotos.size() : 0);

		ProdutoEntity produto = produtoRepository.getOne(produtoId);
		List<UUID> fotoIdList = new ArrayList<>();
		for (MultipartFile file : fotos) {
			FotoEntity foto = new FotoEntity();
			try {
				foto.setNome(file.getOriginalFilename());

				foto.setMiniatura(compressBytes(createThumbnail(file.getInputStream(), 100, 100).toByteArray()));

				foto.setImagem(compressBytes(file.getBytes()));

				foto.setTamanho((long) foto.getImagem().length);
				foto.setTipo(file.getContentType());
				foto.setProduto(produto);
			} catch (Exception e) {
				throw new IllegalArgumentException(MessageFormat.format(
						"Erro ao atribuir arquivo: {0}, para foto em produto com id: {1}. Erro: {2}", file, produtoId,
						e.getMessage()));
			}

			try {
				foto = fotoRepository.saveAndFlush(foto);
				fotoIdList.add(foto.getId());
			} catch (Exception e) {
				throw new IllegalStateException(MessageFormat.format(
						"Erro ao salvar foto: {0} em produto com id: {1}. Erro: {2}", foto, produtoId, e.getMessage()));
			}
		}
		log.info("Finish {} images upload for productId: {}.", produtoId, fotos != null ? fotos.size() : 0);

		return fotoIdList;
	}

	@Transactional(readOnly = true)
	@Override
	public FotoDTO getProdutoFoto(java.util.UUID fotoId) throws Exception {
		log.info("Receiving image downupload for fotoId: {}.", fotoId);

		FotoEntity foto = fotoRepository.findById(fotoId).orElseThrow(() -> {
			return new EntityNotFoundException(
					MessageFormat.format("Registro de Foto com id: {0}, não foi encontrado.", fotoId));
		});

		FotoDTO fotoDTO = fotoEntityToDTO(foto);

		log.info("Downupload for fotoId: {} ready.", fotoId);
		return fotoDTO;
	}

	private FotoDTO fotoEntityToDTO(FotoEntity foto) {
		FotoDTO fotoDTO = new FotoDTO();
		if (foto == null) {
			return fotoDTO;
		}
		fotoDTO.setId(foto.getId());
		fotoDTO.setNome(foto.getNome());
		fotoDTO.setDescricao(foto.getDescricao());
		fotoDTO.setTipo(foto.getTipo());
		fotoDTO.setTamanho(foto.getTamanho());
		String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(decompressBytes(foto.getImagem()));
		fotoDTO.setImagem(encodeImage);

		encodeImage = Base64.getEncoder().withoutPadding().encodeToString(decompressBytes(foto.getMiniatura()));
		fotoDTO.setMiniatura(encodeImage);

		ProdutoLookupResult produto = new ProdutoLookupResult();
		produto.setId(foto.getProduto().getId());
		produto.setNome(foto.getProduto().getNome());

		fotoDTO.setProduto(produto);
		return fotoDTO;
	}

	/*
	 * public UUID produtoFotosUpload_OLD(UUID produtoId, List<MultipartFile> fotos)
	 * {
	 * 
	 * ProdutoEntity produto = produtoRepository.findById(produtoId).orElseThrow(()
	 * -> { return new IllegalStateException(MessageFormat.
	 * format("Produto com id: {0}, não foi encontrado.", produtoId)); });
	 * 
	 * for (MultipartFile file : fotos) { try { FotoEntity foto = new FotoEntity();
	 * foto.setNome(file.getOriginalFilename());
	 * 
	 * foto.setMiniatura(compressBytes(createThumbnail(file.getInputStream(), 100,
	 * 75).toByteArray())); foto.setImagem(compressBytes(file.getBytes()));
	 * 
	 * foto.setTamanho((long)foto.getImagem().length);
	 * foto.setTipo(file.getContentType()); produto.addFoto(foto); } catch
	 * (Exception e) { throw new IllegalArgumentException(MessageFormat.
	 * format("Erro ao atribuir arquivo: {0}, para foto em produto com id: {1}. Erro: {2}"
	 * , file, produtoId, e.getMessage())); } }
	 * 
	 * try { produto = produtoRepository.saveAndFlush(produto); } catch (Exception
	 * e) { throw new IllegalStateException(MessageFormat.
	 * format("Erro ao salvar fotos em produto com id: {0}. Erro: {1}", produtoId,
	 * e.getMessage())); } return produtoId; }
	 */

	private ByteArrayOutputStream createThumbnail(InputStream is, int width, int height) throws Exception {
		ByteArrayOutputStream thumbOutput = new ByteArrayOutputStream();
		Thumbnails.of(is).width(width).toOutputStream(thumbOutput);
		return thumbOutput;
	}

	private ByteArrayOutputStream createThumbnail_OLD(MultipartFile file, int width, int heigth) throws Exception {
		ByteArrayOutputStream thumbOutput = new ByteArrayOutputStream();
		BufferedImage thumbImg = null;

		BufferedImage img = ImageIO.read(file.getInputStream());
		boolean mustRotate = true;// img.getWidth() < img.getHeight();
		thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH, width,
				/* heigth, */ Scalr.OP_ANTIALIAS);

		thumbImg = mustRotate ? Scalr.rotate(thumbImg, Rotation.CW_90) : thumbImg;
		ImageIO.write(thumbImg, file.getContentType().split("/")[1], thumbOutput);
		return thumbOutput;
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		return outputStream.toByteArray();
	}

	// Uncompress the image bytes
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {

		} catch (DataFormatException e) {

		}
		return outputStream.toByteArray();
	}

}
