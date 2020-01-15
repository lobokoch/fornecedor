/**********************************************************************************************
Code generated with MKL Plug-in version: 47.8.0
Code generated at time stamp: 2020-01-13T08:12:25.637
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.entity.fornecedor;

// import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Predicate;

import br.com.kerubin.api.messaging.core.DomainEntityEventsPublisher;
import br.com.kerubin.api.messaging.core.DomainEvent;
import br.com.kerubin.api.messaging.core.DomainEventEnvelope;
import br.com.kerubin.api.messaging.core.DomainEventEnvelopeBuilder;
import br.com.kerubin.api.database.core.ServiceContext;
import br.com.kerubin.api.cadastros.fornecedor.CadastrosFornecedorConstants;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
 
@Service
public class FornecedorServiceImpl implements FornecedorService {
	private static final String ENTITY_KEY = "entity.Fornecedor";
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private FornecedorListFilterPredicate fornecedorListFilterPredicate;
	
	@Autowired
	DomainEntityEventsPublisher publisher;
	
	@Transactional
	@Override
	public FornecedorEntity create(FornecedorEntity fornecedorEntity) {
		FornecedorEntity entity = fornecedorRepository.save(fornecedorEntity);
		publishEvent(entity, FornecedorEvent.FORNECEDOR_CREATED);
		return entity;
	}
	
	@Transactional(readOnly = true)
	@Override
	public FornecedorEntity read(java.util.UUID id) {
		return getFornecedorEntity(id);
	}
	
	@Transactional
	@Override
	public FornecedorEntity update(java.util.UUID id, FornecedorEntity fornecedorEntity) {
		// FornecedorEntity entity = getFornecedorEntity(id);
		// BeanUtils.copyProperties(fornecedorEntity, entity, "id");
		// entity = fornecedorRepository.save(entity);
		
		FornecedorEntity entity = fornecedorRepository.save(fornecedorEntity);
		
		publishEvent(entity, FornecedorEvent.FORNECEDOR_UPDATED);
		
		return entity;
	}
	
	@Transactional
	@Override
	public void delete(java.util.UUID id) {
		
		// First load the delete candidate entity.
		FornecedorEntity entity = getFornecedorEntity(id);
		
		// Delete it.
		fornecedorRepository.deleteById(id);
		
		// Force flush to the database, for relationship validation and must throw exception because of this here.
		fornecedorRepository.flush();
		
		// Replicate the delete event.
		publishEvent(entity, FornecedorEvent.FORNECEDOR_DELETED);
	}
	
	protected void publishEvent(FornecedorEntity entity, String eventName) {
		DomainEvent event = new FornecedorEvent(entity.getId(), 
			entity.getTipoPessoa(), 
			entity.getNome(), 
			entity.getCnpjCPF());
		
		DomainEventEnvelope<DomainEvent> envelope = DomainEventEnvelopeBuilder
				.getBuilder(eventName, event)
				.domain(CadastrosFornecedorConstants.DOMAIN)
				.service(CadastrosFornecedorConstants.SERVICE)
				.key(ENTITY_KEY)
				.tenant(ServiceContext.getTenant())
				.user(ServiceContext.getUser())
				.build();
		
		publisher.publish(envelope);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Page<FornecedorEntity> list(FornecedorListFilter fornecedorListFilter, Pageable pageable) {
		Predicate predicate = fornecedorListFilterPredicate.mountAndGetPredicate(fornecedorListFilter);
		
		Page<FornecedorEntity> resultPage = fornecedorRepository.findAll(predicate, pageable);
		return resultPage;
	}
	
	@Transactional(readOnly = true)
	protected FornecedorEntity getFornecedorEntity(java.util.UUID id) {
		Optional<FornecedorEntity> fornecedorEntity = fornecedorRepository.findById(id);
		if (!fornecedorEntity.isPresent()) {
			throw new IllegalArgumentException("Fornecedor not found:" + id.toString());
		}
		return fornecedorEntity.get();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Collection<FornecedorAutoComplete> autoComplete(String query) {
		Collection<FornecedorAutoComplete> result = fornecedorRepository.autoComplete(query);
		return result;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Collection<FornecedorNomeAutoComplete> fornecedorNomeAutoComplete(String query) {
		Collection<FornecedorNomeAutoComplete> result = fornecedorRepository.fornecedorNomeAutoComplete(query);
		return result;
	}
	
	
}
