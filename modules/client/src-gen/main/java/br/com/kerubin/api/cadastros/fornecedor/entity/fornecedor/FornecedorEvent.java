/**********************************************************************************************
Code generated with MKL Plug-in version: 47.8.0
Code generated at time stamp: 2020-01-13T08:12:25.637
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.entity.fornecedor;

import br.com.kerubin.api.messaging.core.DomainEvent;
import br.com.kerubin.api.cadastros.fornecedor.TipoPessoa;

public class FornecedorEvent implements DomainEvent {
	
	public static final String FORNECEDOR_CREATED = "fornecedorCreated";
	public static final String FORNECEDOR_UPDATED = "fornecedorUpdated";
	public static final String FORNECEDOR_DELETED = "fornecedorDeleted";
	private java.util.UUID id;
	
	private TipoPessoa tipoPessoa;
	
	private String nome;
	
	private String cnpjCPF;
	
	public FornecedorEvent() {
		// Contructor for reflexion, injection, Jackson, QueryDSL, etc proposal.
	}
	
	public FornecedorEvent(java.util.UUID id, TipoPessoa tipoPessoa, String nome, String cnpjCPF) {
		this.id = id;
		this.tipoPessoa = tipoPessoa;
		this.nome = nome;
		this.cnpjCPF = cnpjCPF;
	}
	
	public java.util.UUID getId() {
		return id;
	}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCnpjCPF() {
		return cnpjCPF;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCnpjCPF(String cnpjCPF) {
		this.cnpjCPF = cnpjCPF;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorEvent other = (FornecedorEvent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
	
	/* 
	@Override
	public String toString() {
		// Enabling toString for JPA entities will implicitly trigger lazy loading on all fields.
	}
	*/

}
