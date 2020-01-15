/**********************************************************************************************
Code generated with MKL Plug-in version: 47.8.0
Code generated at time stamp: 2020-01-13T08:12:25.637
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.entity.fornecedor;

import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.com.kerubin.api.cadastros.fornecedor.common.PageResult;

import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("cadastros/fornecedor/entities/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	FornecedorDTOConverter fornecedorDTOConverter;
	
	@Transactional
	@PostMapping
	public ResponseEntity<Fornecedor> create(@Valid @RequestBody Fornecedor fornecedor) {
		FornecedorEntity fornecedorEntity = fornecedorService.create(fornecedorDTOConverter.convertDtoToEntity(fornecedor));
		return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorDTOConverter.convertEntityToDto(fornecedorEntity));
	}
	
	@Transactional(readOnly = true)
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> read(@PathVariable java.util.UUID id) {
		try {
			FornecedorEntity fornecedorEntity = fornecedorService.read(id);
			return ResponseEntity.ok(fornecedorDTOConverter.convertEntityToDto(fornecedorEntity));
		}
		catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> update(@PathVariable java.util.UUID id, @Valid @RequestBody Fornecedor fornecedor) {
		try {
			FornecedorEntity fornecedorEntity = fornecedorService.update(id, fornecedorDTOConverter.convertDtoToEntity(fornecedor));
			return ResponseEntity.ok(fornecedorDTOConverter.convertEntityToDto(fornecedorEntity));
		}
		catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable java.util.UUID id) {
		fornecedorService.delete(id);
	}
	
	@Transactional(readOnly = true)
	@GetMapping
	public PageResult<Fornecedor> list(FornecedorListFilter fornecedorListFilter, Pageable pageable) {
		Page<FornecedorEntity> page = fornecedorService.list(fornecedorListFilter, pageable);
		List<Fornecedor> content = page.getContent().stream().map(pe -> fornecedorDTOConverter.convertEntityToDto(pe)).collect(Collectors.toList());
		PageResult<Fornecedor> pageResult = new PageResult<>(content, page.getNumber(), page.getSize(), page.getTotalElements());
		return pageResult;
	}
	
	@Transactional(readOnly = true)
	@GetMapping("/autoComplete")
	public Collection<FornecedorAutoComplete> autoComplete(@RequestParam("query") String query) {
		Collection<FornecedorAutoComplete> result = fornecedorService.autoComplete(query);
		return result;
	}
	
	
	@GetMapping("/fornecedorNomeAutoComplete")
	public Collection<FornecedorNomeAutoComplete> fornecedorNomeAutoComplete(@RequestParam("query") String query) {
		Collection<FornecedorNomeAutoComplete> result = fornecedorService.fornecedorNomeAutoComplete(query);
		return result;
	}
	
	
}
