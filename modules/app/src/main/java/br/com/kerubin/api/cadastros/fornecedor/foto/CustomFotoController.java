/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.foto;

import java.util.UUID;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cadastros/fornecedor/entities/produto2")
public class CustomFotoController {
	
	@Inject
	private ProdutoFotosService produtoFotosService;
	
	/*@PostMapping("/produtoFotosUpload/{produtoId}")
	public List<UUID> produtoFotosUpload(@PathVariable UUID produtoId, @RequestParam List<MultipartFile> produtoFotosUpload) {
		return produtoFotosService.produtoFotosUpload(produtoId, produtoFotosUpload);
	}*/
	
	@PostMapping("/uploadProdutoFotoAndGet/{produtoId}")
	public ResponseEntity<FotoDTO> uploadProdutoFotoAndGet(@PathVariable UUID produtoId, @RequestParam MultipartFile foto) {
		return ResponseEntity.ok(produtoFotosService.uploadProdutoFotoAndGet(produtoId, foto));
	}
	
	@GetMapping("/getProdutoFoto/{fotoId}")
	public ResponseEntity<FotoDTO> getProdutoFoto(@PathVariable java.util.UUID fotoId) throws Exception {
		return ResponseEntity.ok(produtoFotosService.getProdutoFoto(fotoId));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/deleteProdutoFotosItem/{fotoId}")
	public void deleteProdutoFotosItem(@PathVariable java.util.UUID fotoId) throws Exception {
		produtoFotosService.deleteProdutoFotosItem(fotoId);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/updateProdutoFotosDescricao/{fotoId}")
	public void updateProdutoFotosDescricao(@PathVariable java.util.UUID fotoId, @RequestBody String descricao) throws Exception {
		produtoFotosService.updateProdutoFotosDescricao(fotoId, descricao);
	}
	
}
