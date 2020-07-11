package br.com.kerubin.api.cadastros.fornecedor.foto;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public interface ProdutoFotosService {
	
	List<UUID> produtoFotosUpload(UUID produtoId, List<MultipartFile> fotos);

	FotoDTO getProdutoFoto(UUID fotoId) throws Exception;

	FotoDTO uploadProdutoFotoAndGet(UUID produtoId, MultipartFile foto);

}
