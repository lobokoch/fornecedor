/**********************************************************************************************
Code generated with MKL Plug-in version: 47.8.0
Code generated at time stamp: 2020-01-13T08:12:25.637
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.entity.fornecedor;

import br.com.kerubin.api.cadastros.fornecedor.TipoPessoa;
import br.com.kerubin.api.cadastros.fornecedor.UF;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import javax.inject.Inject;
import org.springframework.boot.test.mock.mockito.MockBean;
import br.com.kerubin.api.messaging.core.DomainEntityEventsPublisher;
import static org.mockito.Mockito.doAnswer;
import br.com.kerubin.api.messaging.core.DomainEventEnvelope;
import static org.mockito.ArgumentMatchers.any;
import br.com.kerubin.api.messaging.core.DomainEvent;
import br.com.kerubin.api.cadastros.fornecedor.CadastrosFornecedorConstants;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import br.com.kerubin.api.cadastros.fornecedor.common.PageResult;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import br.com.kerubin.api.cadastros.fornecedor.CadastrosFornecedorBaseEntityTest;


@RunWith(SpringRunner.class)
public class FornecedorServiceTest extends CadastrosFornecedorBaseEntityTest {
	
	private static final String[] IGNORED_FIELDS = { "id" };
	
	@TestConfiguration
	static class FornecedorServiceTestConfig {
		
		@Bean
		public FornecedorListFilterPredicate fornecedorListFilterPredicate() {
			return new FornecedorListFilterPredicateImpl();
		}
		
		@Bean
		public FornecedorService fornecedorService() {
			return new FornecedorServiceImpl();
		}
		
		@Bean
		public FornecedorDTOConverter fornecedorDTOConverter() {
			return new FornecedorDTOConverter();
		}
		
	}
	
	
	@Inject
	protected FornecedorService fornecedorService;
	
	@Inject
	protected FornecedorDTOConverter fornecedorDTOConverter;
	
	@Inject
	protected FornecedorRepository fornecedorRepository;
	
	@MockBean
	protected DomainEntityEventsPublisher publisher;
	
	// BEGIN CREATE TESTS
	
	@Test
	public void testCreateWithAllFields() throws Exception {
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setId(java.util.UUID.randomUUID());
		fornecedor.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		fornecedor.setNome(generateRandomString(255));
		fornecedor.setCnpjCPF(generateRandomString(255));
		fornecedor.setIeRG(generateRandomString(255));
		fornecedor.setDataFundacaoNascimento(getNextDate());
		fornecedor.setNomeContato(generateRandomString(255));
		fornecedor.setFone(generateRandomString(255));
		fornecedor.setCelular(generateRandomString(255));
		fornecedor.setEmail(generateRandomString(255));
		fornecedor.setSite(generateRandomString(255));
		fornecedor.setCep(generateRandomString(255));
		fornecedor.setUf(UF.SC);
		fornecedor.setCidade(generateRandomString(255));
		fornecedor.setBairro(generateRandomString(255));
		fornecedor.setEndereco(generateRandomString(255));
		fornecedor.setNumero(generateRandomString(255));
		fornecedor.setComplemento(generateRandomString(255));
		fornecedor.setObservacoes(generateRandomString(1000));
		fornecedor.setAtivo(true);
		
		// BEGIN check event created.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			FornecedorEvent event = (FornecedorEvent) envelope.getPayload();
			assertThat(event.getId()).isNotNull();
			assertThat(event.getTipoPessoa()).isEqualTo(fornecedor.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(fornecedor.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(fornecedor.getCnpjCPF());
			
			assertThat(CadastrosFornecedorConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosFornecedorConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("fornecedorCreated").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Fornecedor").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event created.
		
		FornecedorEntity fornecedorEntity = fornecedorService.create(fornecedorDTOConverter.convertDtoToEntity(fornecedor));
		em.flush();
		verify(publisher, times(1)).publish(any());
		Fornecedor actual = fornecedorDTOConverter.convertEntityToDto(fornecedorEntity);
		
		
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isNotNull();
		assertThat(actual).isEqualToIgnoringGivenFields(fornecedor, IGNORED_FIELDS);
		
		
	}
	
	@Test
	public void testCreateWithOnlyRecairedFields() throws Exception {
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setId(java.util.UUID.randomUUID());
		fornecedor.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		fornecedor.setNome(generateRandomString(255));
		
		// BEGIN check event created.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			FornecedorEvent event = (FornecedorEvent) envelope.getPayload();
			assertThat(event.getId()).isNotNull();
			assertThat(event.getTipoPessoa()).isEqualTo(fornecedor.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(fornecedor.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(fornecedor.getCnpjCPF());
			
			assertThat(CadastrosFornecedorConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosFornecedorConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("fornecedorCreated").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Fornecedor").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event created.
		
		FornecedorEntity fornecedorEntity = fornecedorService.create(fornecedorDTOConverter.convertDtoToEntity(fornecedor));
		em.flush();
		verify(publisher, times(1)).publish(any());
		Fornecedor actual = fornecedorDTOConverter.convertEntityToDto(fornecedorEntity);
		
		
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isNotNull();
		assertThat(actual).isEqualToIgnoringGivenFields(fornecedor, IGNORED_FIELDS);
		
		
	}
	// END CREATE TESTS
	
	// BEGIN READ TESTS
	
	@Test
	public void testRead1() {
		FornecedorEntity expectedFornecedorEntity = newFornecedorEntity();
		java.util.UUID id = expectedFornecedorEntity.getId();
		Fornecedor expected = fornecedorDTOConverter.convertEntityToDto(expectedFornecedorEntity);
		FornecedorEntity readFornecedorEntity = fornecedorService.read(id);
		Fornecedor actual = fornecedorDTOConverter.convertEntityToDto(readFornecedorEntity);
		
		assertThat(actual).isEqualToComparingFieldByField(expected);
		
	}
	// END READ TESTS
	
	// BEGIN UPDATE TESTS
	
	@Test
	public void testUpdateWithAllFields() throws Exception {
		FornecedorEntity oldFornecedorEntity = newFornecedorEntity();
		java.util.UUID id = oldFornecedorEntity.getId();
				
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);
		
		fornecedor.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		fornecedor.setNome(generateRandomString(255));
		fornecedor.setCnpjCPF(generateRandomString(255));
		fornecedor.setIeRG(generateRandomString(255));
		fornecedor.setDataFundacaoNascimento(getNextDate());
		fornecedor.setNomeContato(generateRandomString(255));
		fornecedor.setFone(generateRandomString(255));
		fornecedor.setCelular(generateRandomString(255));
		fornecedor.setEmail(generateRandomString(255));
		fornecedor.setSite(generateRandomString(255));
		fornecedor.setCep(generateRandomString(255));
		fornecedor.setUf(UF.SC);
		fornecedor.setCidade(generateRandomString(255));
		fornecedor.setBairro(generateRandomString(255));
		fornecedor.setEndereco(generateRandomString(255));
		fornecedor.setNumero(generateRandomString(255));
		fornecedor.setComplemento(generateRandomString(255));
		fornecedor.setObservacoes(generateRandomString(1000));
		fornecedor.setAtivo(true);
		
		// BEGIN check event updated.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			FornecedorEvent event = (FornecedorEvent) envelope.getPayload();
			assertThat(event.getId()).isEqualTo(fornecedor.getId());
			assertThat(event.getTipoPessoa()).isEqualTo(fornecedor.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(fornecedor.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(fornecedor.getCnpjCPF());
			
			assertThat(CadastrosFornecedorConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosFornecedorConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("fornecedorUpdated").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Fornecedor").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event updated.
		
		FornecedorEntity fornecedorEntity = fornecedorService.update(id, fornecedorDTOConverter.convertDtoToEntity(fornecedor));
		em.flush();
		verify(publisher, times(1)).publish(any());
		
		Fornecedor actual = fornecedorDTOConverter.convertEntityToDto(fornecedorEntity);
		
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isNotNull();
		assertThat(actual).isEqualToIgnoringGivenFields(fornecedor, IGNORED_FIELDS);
		
		
	}
	
	@Test
	public void testUpdateWithOnlyRecairedFields() throws Exception {
		FornecedorEntity oldFornecedorEntity = newFornecedorEntity();
		java.util.UUID id = oldFornecedorEntity.getId();
				
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);
		
		fornecedor.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		fornecedor.setNome(generateRandomString(255));
		
		// BEGIN check event updated.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			FornecedorEvent event = (FornecedorEvent) envelope.getPayload();
			assertThat(event.getId()).isEqualTo(fornecedor.getId());
			assertThat(event.getTipoPessoa()).isEqualTo(fornecedor.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(fornecedor.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(fornecedor.getCnpjCPF());
			
			assertThat(CadastrosFornecedorConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosFornecedorConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("fornecedorUpdated").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Fornecedor").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event updated.
		
		FornecedorEntity fornecedorEntity = fornecedorService.update(id, fornecedorDTOConverter.convertDtoToEntity(fornecedor));
		em.flush();
		verify(publisher, times(1)).publish(any());
		
		Fornecedor actual = fornecedorDTOConverter.convertEntityToDto(fornecedorEntity);
		
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isNotNull();
		assertThat(actual).isEqualToIgnoringGivenFields(fornecedor, IGNORED_FIELDS);
		
		
	}
	// END UPDATE TESTS
	
	// BEGIN DELETE TESTS
	
	@Test
	public void testDelete1() {
		FornecedorEntity expected = newFornecedorEntity();
		java.util.UUID id = expected.getId();
		
		FornecedorEntity fornecedor = expected;
		
		expected = em.find(FornecedorEntity.class, id);
		assertThat(expected).isNotNull();
		
		// BEGIN check event deleted.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			FornecedorEvent event = (FornecedorEvent) envelope.getPayload();
			assertThat(event.getId()).isEqualTo(fornecedor.getId());
			assertThat(event.getTipoPessoa()).isEqualTo(fornecedor.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(fornecedor.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(fornecedor.getCnpjCPF());
			
			assertThat(CadastrosFornecedorConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosFornecedorConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("fornecedorDeleted").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Fornecedor").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event deleted.
		
		fornecedorService.delete(id);
		verify(publisher, times(1)).publish(any());
		
		expected = em.find(FornecedorEntity.class, id);
		assertThat(expected).isNull();
	}
	// END DELETE TESTS
	
	// BEGIN LIST TESTS
	
	@Test
	public void testList_FilteringByNome() {
		// Reset lastDate field to start LocalDate fields with today in this test. 
		resetNextDate();
		
		// Generate 33 records of data for FornecedorEntity for this test.
		List<FornecedorEntity> testData = new ArrayList<>();
		final int lastRecord = 33;
		final int firstRecord = 1;
		for (int i = firstRecord; i <= lastRecord; i++) {
			testData.add(newFornecedorEntity());
		}
		
		// Check if 33 records of FornecedorEntity was generated.
		long count = fornecedorRepository.count();
		assertThat(count).isEqualTo(lastRecord);
		
		// Creates a list filter for entity Fornecedor.
		FornecedorListFilter listFilter = new FornecedorListFilter();
		
		// Extracts 7 records of FornecedorEntity randomly from testData.
		final int resultSize = 7;
		List<FornecedorEntity> filterTestData = getRandomItemsOf(testData, resultSize);
		
		// Extracts a list with only FornecedorEntity.nome field and configure this list as a filter.
		List<String> nomeListFilter = filterTestData.stream().map(FornecedorEntity::getNome).collect(Collectors.toList());
		listFilter.setNome(nomeListFilter);
		
		// Generates a pageable configuration, without sorting.
		int pageIndex = 0; // First page starts at index zero.
		int size = 33; // Max of 33 records per page.
		Pageable pageable = PageRequest.of(pageIndex, size);
		// Call service list method.
		Page<FornecedorEntity> page = fornecedorService.list(listFilter, pageable);
		
		// Converts found entities to DTOs and mount the result page.
		List<Fornecedor> content = page.getContent().stream().map(it -> fornecedorDTOConverter.convertEntityToDto(it)).collect(Collectors.toList());
		PageResult<Fornecedor> pageResult = new PageResult<>(content, page.getNumber(), page.getSize(), page.getTotalElements());
		
		// Asserts that result has size 7, in any order and has only rows with nomeListFilter elements based on nome field.
		assertThat(pageResult.getContent())
		.hasSize(7)
		.extracting(Fornecedor::getNome)
		.containsExactlyInAnyOrderElementsOf(nomeListFilter);
		
		// Asserts some page result elements.
		assertThat(pageResult.getNumber()).isEqualTo(pageIndex);
		assertThat(pageResult.getNumberOfElements()).isEqualTo(7);
		assertThat(pageResult.getTotalElements()).isEqualTo(7);
		assertThat(pageResult.getTotalPages()).isEqualTo(1);
		
	}
	
	@Test
	public void testList_FilteringByNomeWithoutResults() {
		// Reset lastDate field to start LocalDate fields with today in this test. 
		resetNextDate();
					
		// Generate 33 records of data for FornecedorEntity for this test.
		List<FornecedorEntity> testData = new ArrayList<>();
		final int lastRecord = 33;
		final int firstRecord = 1;
		for (int i = firstRecord; i <= lastRecord; i++) {
			testData.add(newFornecedorEntity());
		}
		
		// Check if 33 records of FornecedorEntity was generated.
		long count = fornecedorRepository.count();
		assertThat(count).isEqualTo(lastRecord);
		
		// Creates a list filter for entity Fornecedor.
		FornecedorListFilter listFilter = new FornecedorListFilter();
		
		// Generates a list with only FornecedorEntity.nome field with 1 not found data in the database and configure this list as a filter.
		List<String> nomeListFilter = Arrays.asList(generateRandomString(255));
		listFilter.setNome(nomeListFilter);
		
		// Generates a pageable configuration, without sorting.
		int pageIndex = 0; // First page starts at index zero.
		int size = 33; // Max of 33 records per page.
		Pageable pageable = PageRequest.of(pageIndex, size);
		// Call service list method.
		Page<FornecedorEntity> page = fornecedorService.list(listFilter, pageable);
		
		// Converts found entities to DTOs and mount the result page.
		List<Fornecedor> content = page.getContent().stream().map(it -> fornecedorDTOConverter.convertEntityToDto(it)).collect(Collectors.toList());
		PageResult<Fornecedor> pageResult = new PageResult<>(content, page.getNumber(), page.getSize(), page.getTotalElements());
		
		// Asserts that result has size 0 for unknown nome field.
		assertThat(pageResult.getContent()).hasSize(0);
		
	}
	// END LIST TESTS
	
	// BEGIN Autocomplete TESTS
	@Test
	public void testAutoComplete() {
		// Reset lastDate field to start LocalDate fields with today in this test. 
		resetNextDate();
					
		// Generate 33 records of data for FornecedorEntity for this test.
		List<FornecedorEntity> testData = new ArrayList<>();
		final int lastRecord = 33;
		final int firstRecord = 1;
		for (int i = firstRecord; i <= lastRecord; i++) {
			testData.add(newFornecedorEntity());
		}
		
		// Check if 33 records of FornecedorEntity was generated.
		long count = fornecedorRepository.count();
		assertThat(count).isEqualTo(lastRecord);
		
		// Extracts 1 records of FornecedorEntity randomly from testData.
		final int resultSize = 1;
		List<FornecedorEntity> filterTestData = getRandomItemsOf(testData, resultSize);
		
		// Extracts a list with only FornecedorEntity.nome field and configure this list as a filter.
		List<String> nomeListFilter = filterTestData.stream().map(FornecedorEntity::getNome).collect(Collectors.toList());
		// Mount the autocomplete query expression and call it.
		String query = nomeListFilter.get(0);
		Collection<FornecedorAutoComplete> result = fornecedorService.autoComplete(query);
		
		// Assert FornecedorAutoComplete results.
		assertThat(result).isNotNull().hasSize(1)
		.extracting(FornecedorAutoComplete::getNome)
		.containsExactlyInAnyOrderElementsOf(nomeListFilter);
	}
	
	// END Autocomplete TESTS
	
	// BEGIN ListFilter Autocomplete TESTS
	
	@Test
	public void testFornecedorNomeAutoComplete() {
		// Reset lastDate field to start LocalDate fields with today in this test. 
		resetNextDate();
					
		// Generate 33 records of data for FornecedorEntity for this test.
		List<FornecedorEntity> testData = new ArrayList<>();
		final int lastRecord = 33;
		final int firstRecord = 1;
		for (int i = firstRecord; i <= lastRecord; i++) {
			testData.add(newFornecedorEntity());
		}
		
		// Check if 33 records of FornecedorEntity was generated.
		long count = fornecedorRepository.count();
		assertThat(count).isEqualTo(lastRecord);
		
		// Extracts 1 records of FornecedorEntity randomly from testData.
		final int resultSize = 1;
		List<FornecedorEntity> filterTestData = getRandomItemsOf(testData, resultSize);
		
		// Extracts a list with only FornecedorEntity.nome field and configure this list as a filter.
		List<String> nomeListFilter = filterTestData.stream().map(FornecedorEntity::getNome).collect(Collectors.toList());
		// Mount the autocomplete query expression and call it.
		String query = nomeListFilter.get(0);
		Collection<FornecedorNomeAutoComplete> result = fornecedorService.fornecedorNomeAutoComplete(query);
		// Assert FornecedorNomeAutoComplete results.
		assertThat(result).isNotNull().hasSize(1)
		.extracting(FornecedorNomeAutoComplete::getNome)
		.containsExactlyInAnyOrderElementsOf(nomeListFilter);
	}
	
	// END ListFilter Autocomplete TESTS
	
	
	// BEGIN tests for Sum Fields
	// END tests for Sum Fields
	
	// BEGIN tests for Sum Fields
	// END tests for Sum Fields
	
	// BEGIN TESTS DEPENDENCIES
	
	
	protected FornecedorEntity newFornecedorEntity() {
		FornecedorEntity fornecedorEntity = new FornecedorEntity();
		
		fornecedorEntity.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		fornecedorEntity.setNome(generateRandomString(255));
		fornecedorEntity.setCnpjCPF(generateRandomString(255));
		fornecedorEntity.setIeRG(generateRandomString(255));
		fornecedorEntity.setDataFundacaoNascimento(getNextDate());
		fornecedorEntity.setNomeContato(generateRandomString(255));
		fornecedorEntity.setFone(generateRandomString(255));
		fornecedorEntity.setCelular(generateRandomString(255));
		fornecedorEntity.setEmail(generateRandomString(255));
		fornecedorEntity.setSite(generateRandomString(255));
		fornecedorEntity.setCep(generateRandomString(255));
		fornecedorEntity.setUf(UF.SC);
		fornecedorEntity.setCidade(generateRandomString(255));
		fornecedorEntity.setBairro(generateRandomString(255));
		fornecedorEntity.setEndereco(generateRandomString(255));
		fornecedorEntity.setNumero(generateRandomString(255));
		fornecedorEntity.setComplemento(generateRandomString(255));
		fornecedorEntity.setObservacoes(generateRandomString(1000));
		fornecedorEntity.setAtivo(true);
		
		fornecedorEntity = em.persistAndFlush(fornecedorEntity);
		return fornecedorEntity;
	}
	
	
	protected FornecedorLookupResult newFornecedorLookupResult(FornecedorEntity fornecedorEntity) {
		FornecedorLookupResult fornecedor = new FornecedorLookupResult();
		
		fornecedor.setId(fornecedorEntity.getId());
		fornecedor.setNome(fornecedorEntity.getNome());
		
		return fornecedor;
	}
	// END TESTS DEPENDENCIES

}
