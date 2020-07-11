/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.entity.produto;

import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.kerubin.api.cadastros.fornecedor.entity.foto.FotoAutoComplete;

public interface ProdutoService {
	
	public ProdutoEntity create(ProdutoEntity produtoEntity);
	
	public ProdutoEntity read(java.util.UUID id);
	
	public ProdutoEntity update(java.util.UUID id, ProdutoEntity produtoEntity);
	
	public void delete(java.util.UUID id);
	
	public void deleteInBulk(java.util.List<java.util.UUID> idList);
	
	public Page<ProdutoEntity> list(ProdutoListFilter produtoListFilter, Pageable pageable);
	
	public Collection<ProdutoAutoComplete> autoComplete(String query);
	
	// Begin relationships autoComplete 
	public Collection<FotoAutoComplete> fotoFotosAutoComplete(String query);
	// End relationships autoComplete
	 
}
