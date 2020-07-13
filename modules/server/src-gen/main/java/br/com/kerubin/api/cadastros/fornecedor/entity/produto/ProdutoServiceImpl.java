/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.entity.produto;

// import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Predicate;


import br.com.kerubin.api.cadastros.fornecedor.entity.foto.FotoAutoComplete;

import br.com.kerubin.api.cadastros.fornecedor.entity.foto.FotoRepository;

import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
 
@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoListFilterPredicate produtoListFilterPredicate;
	
	
	@Autowired
	private FotoRepository fotoRepository;
	
	
	@Transactional
	@Override
	public ProdutoEntity create(ProdutoEntity produtoEntity) {
		return produtoRepository.save(produtoEntity);
	}
	
	@Transactional(readOnly = true)
	@Override
	public ProdutoEntity read(java.util.UUID id) {
		return getProdutoEntity(id);
	}
	
	@Transactional
	@Override
	public ProdutoEntity update(java.util.UUID id, ProdutoEntity produtoEntity) {
		// ProdutoEntity entity = getProdutoEntity(id);
		// BeanUtils.copyProperties(produtoEntity, entity, "id");
		// entity = produtoRepository.save(entity);
		
		ProdutoEntity entity = produtoRepository.save(produtoEntity);
		
		return entity;
	}
	
	@Transactional
	@Override
	public void delete(java.util.UUID id) {
		
		// Delete it.
		produtoRepository.deleteById(id);
		
		// Force flush to the database, for relationship validation and must throw exception because of this here.
		produtoRepository.flush();
		
	}
	
	@Transactional
	@Override
	public void deleteInBulk(java.util.List<java.util.UUID> idList) {
		// Delete it.
		produtoRepository.deleteInBulk(idList);
		
		// Force flush to the database, for relationship validation and must throw exception because of this here.
		produtoRepository.flush();
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public Page<ProdutoEntity> list(ProdutoListFilter produtoListFilter, Pageable pageable) {
		Predicate predicate = produtoListFilterPredicate.mountAndGetPredicate(produtoListFilter);
		
		Page<ProdutoEntity> resultPage = produtoRepository.findAll(predicate, pageable);
		return resultPage;
	}
	
	@Transactional(readOnly = true)
	protected ProdutoEntity getProdutoEntity(java.util.UUID id) {
		Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
		if (!produtoEntity.isPresent()) {
			throw new IllegalArgumentException("Produto not found:" + id.toString());
		}
		return produtoEntity.get();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Collection<ProdutoAutoComplete> autoComplete(String query) {
		Collection<ProdutoAutoComplete> result = produtoRepository.autoComplete(query);
		return result;
	}
	
	// Begin relationships autoComplete 
	@Transactional(readOnly = true)
	@Override
	public Collection<FotoAutoComplete> fotoFotosAutoComplete(String query) {
		Collection<FotoAutoComplete> result = fotoRepository.autoComplete(query);
		return result;
	}
	
	// End relationships autoComplete
	
	
	
}