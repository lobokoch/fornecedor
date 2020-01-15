/**********************************************************************************************
Code generated with MKL Plug-in version: 47.8.0
Code generated at time stamp: 2020-01-13T08:12:25.637
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.entity.fornecedor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import javax.validation.constraints.NotNull;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import br.com.kerubin.api.cadastros.fornecedor.TipoPessoa;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.com.kerubin.api.cadastros.fornecedor.UF;

@Entity
@Table(name = "fornecedor")
public class FornecedorEntity  {

	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Id
	@Column(name="id")
	private java.util.UUID id;
	
	@NotNull(message="\"Tipo do fornecedor\" é obrigatório.")
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_pessoa")
	private TipoPessoa tipoPessoa;
	
	@NotBlank(message="\"Nome\" é obrigatório.")
	@Size(max = 255, message = "\"Nome\" pode ter no máximo 255 caracteres.")
	@Column(name="nome")
	private String nome;
	
	@Size(max = 255, message = "\"Documento (CNPJ/CPF)\" pode ter no máximo 255 caracteres.")
	@Column(name="cnpj_cpf")
	private String cnpjCPF;
	
	@Size(max = 255, message = "\"Documento (IE/RG)\" pode ter no máximo 255 caracteres.")
	@Column(name="ie_rg")
	private String ieRG;
	
	@Column(name="data_fundacao_nascimento")
	private java.time.LocalDate dataFundacaoNascimento;
	
	@Size(max = 255, message = "\"Nome para contato\" pode ter no máximo 255 caracteres.")
	@Column(name="nome_contato")
	private String nomeContato;
	
	@Size(max = 255, message = "\"Telefone\" pode ter no máximo 255 caracteres.")
	@Column(name="fone")
	private String fone;
	
	@Size(max = 255, message = "\"Celular\" pode ter no máximo 255 caracteres.")
	@Column(name="celular")
	private String celular;
	
	@Size(max = 255, message = "\"E-mail\" pode ter no máximo 255 caracteres.")
	@Column(name="email")
	private String email;
	
	@Size(max = 255, message = "\"Site\" pode ter no máximo 255 caracteres.")
	@Column(name="site")
	private String site;
	
	@Size(max = 255, message = "\"CEP\" pode ter no máximo 255 caracteres.")
	@Column(name="cep")
	private String cep;
	
	@Enumerated(EnumType.STRING)
	@Column(name="uf")
	private UF uf;
	
	@Size(max = 255, message = "\"Cidade\" pode ter no máximo 255 caracteres.")
	@Column(name="cidade")
	private String cidade;
	
	@Size(max = 255, message = "\"Bairro\" pode ter no máximo 255 caracteres.")
	@Column(name="bairro")
	private String bairro;
	
	@Size(max = 255, message = "\"Endereço\" pode ter no máximo 255 caracteres.")
	@Column(name="endereco")
	private String endereco;
	
	@Size(max = 255, message = "\"Número\" pode ter no máximo 255 caracteres.")
	@Column(name="numero")
	private String numero;
	
	@Size(max = 255, message = "\"Complemento\" pode ter no máximo 255 caracteres.")
	@Column(name="complemento")
	private String complemento;
	
	@Size(max = 1000, message = "\"Observações\" pode ter no máximo 1000 caracteres.")
	@Column(name="observacoes")
	private String observacoes;
	
	@Column(name="ativo")
	private Boolean ativo = true;
	
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
	
	public String getIeRG() {
		return ieRG;
	}
	
	public java.time.LocalDate getDataFundacaoNascimento() {
		return dataFundacaoNascimento;
	}
	
	public String getNomeContato() {
		return nomeContato;
	}
	
	public String getFone() {
		return fone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSite() {
		return site;
	}
	
	public String getCep() {
		return cep;
	}
	
	public UF getUf() {
		return uf;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public void setNome(String nome) {
		this.nome = nome != null ? nome.trim() : nome; // Chamadas REST fazem trim.
	}
	
	public void setCnpjCPF(String cnpjCPF) {
		this.cnpjCPF = cnpjCPF != null ? cnpjCPF.trim() : cnpjCPF; // Chamadas REST fazem trim.
	}
	
	public void setIeRG(String ieRG) {
		this.ieRG = ieRG != null ? ieRG.trim() : ieRG; // Chamadas REST fazem trim.
	}
	
	public void setDataFundacaoNascimento(java.time.LocalDate dataFundacaoNascimento) {
		this.dataFundacaoNascimento = dataFundacaoNascimento;
	}
	
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato != null ? nomeContato.trim() : nomeContato; // Chamadas REST fazem trim.
	}
	
	public void setFone(String fone) {
		this.fone = fone != null ? fone.trim() : fone; // Chamadas REST fazem trim.
	}
	
	public void setCelular(String celular) {
		this.celular = celular != null ? celular.trim() : celular; // Chamadas REST fazem trim.
	}
	
	public void setEmail(String email) {
		this.email = email != null ? email.trim() : email; // Chamadas REST fazem trim.
	}
	
	public void setSite(String site) {
		this.site = site != null ? site.trim() : site; // Chamadas REST fazem trim.
	}
	
	public void setCep(String cep) {
		this.cep = cep != null ? cep.trim() : cep; // Chamadas REST fazem trim.
	}
	
	public void setUf(UF uf) {
		this.uf = uf;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade != null ? cidade.trim() : cidade; // Chamadas REST fazem trim.
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro != null ? bairro.trim() : bairro; // Chamadas REST fazem trim.
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco != null ? endereco.trim() : endereco; // Chamadas REST fazem trim.
	}
	
	public void setNumero(String numero) {
		this.numero = numero != null ? numero.trim() : numero; // Chamadas REST fazem trim.
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento != null ? complemento.trim() : complemento; // Chamadas REST fazem trim.
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes != null ? observacoes.trim() : observacoes; // Chamadas REST fazem trim.
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public void assign(FornecedorEntity source) {
		if (source != null) {
			this.setId(source.getId());
			this.setTipoPessoa(source.getTipoPessoa());
			this.setNome(source.getNome());
			this.setCnpjCPF(source.getCnpjCPF());
			this.setIeRG(source.getIeRG());
			this.setDataFundacaoNascimento(source.getDataFundacaoNascimento());
			this.setNomeContato(source.getNomeContato());
			this.setFone(source.getFone());
			this.setCelular(source.getCelular());
			this.setEmail(source.getEmail());
			this.setSite(source.getSite());
			this.setCep(source.getCep());
			this.setUf(source.getUf());
			this.setCidade(source.getCidade());
			this.setBairro(source.getBairro());
			this.setEndereco(source.getEndereco());
			this.setNumero(source.getNumero());
			this.setComplemento(source.getComplemento());
			this.setObservacoes(source.getObservacoes());
			this.setAtivo(source.getAtivo());
		}
	}
	
	public FornecedorEntity clone() {
		return clone(new java.util.HashMap<>());
	}
	
	public FornecedorEntity clone(java.util.Map<Object, Object> visited) {
		if (visited.containsKey(this)) {
			return (FornecedorEntity) visited.get(this);
		}
				
		FornecedorEntity theClone = new FornecedorEntity();
		visited.put(this, theClone);
		
		theClone.setId(this.getId());
		theClone.setTipoPessoa(this.getTipoPessoa());
		theClone.setNome(this.getNome());
		theClone.setCnpjCPF(this.getCnpjCPF());
		theClone.setIeRG(this.getIeRG());
		theClone.setDataFundacaoNascimento(this.getDataFundacaoNascimento());
		theClone.setNomeContato(this.getNomeContato());
		theClone.setFone(this.getFone());
		theClone.setCelular(this.getCelular());
		theClone.setEmail(this.getEmail());
		theClone.setSite(this.getSite());
		theClone.setCep(this.getCep());
		theClone.setUf(this.getUf());
		theClone.setCidade(this.getCidade());
		theClone.setBairro(this.getBairro());
		theClone.setEndereco(this.getEndereco());
		theClone.setNumero(this.getNumero());
		theClone.setComplemento(this.getComplemento());
		theClone.setObservacoes(this.getObservacoes());
		theClone.setAtivo(this.getAtivo());
		
		return theClone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorEntity other = (FornecedorEntity) obj;
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
