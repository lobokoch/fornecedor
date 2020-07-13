/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.entity.foto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import javax.validation.constraints.Size;
import br.com.kerubin.api.cadastros.fornecedor.entity.produto.ProdutoEntity;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "foto")
public class FotoEntity  {

	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Id
	@Column(name="id")
	private java.util.UUID id;
	
	@Size(max = 255, message = "\"nome\" pode ter no máximo 255 caracteres.")
	@Column(name="nome")
	private String nome;
	
	@Size(max = 255, message = "\"descricao\" pode ter no máximo 255 caracteres.")
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="tamanho")
	private Long tamanho;
	
	@Size(max = 255, message = "\"tipo\" pode ter no máximo 255 caracteres.")
	@Column(name="tipo")
	private String tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto")
	private ProdutoEntity produto;
	
	public java.util.UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Long getTamanho() {
		return tamanho;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public ProdutoEntity getProduto() {
		return produto;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome != null ? nome.trim() : nome; // Chamadas REST fazem trim.
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao != null ? descricao.trim() : descricao; // Chamadas REST fazem trim.
	}
	
	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo != null ? tipo.trim() : tipo; // Chamadas REST fazem trim.
	}
	
	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}
	
	public void assign(FotoEntity source) {
		if (source != null) {
			this.setId(source.getId());
			this.setNome(source.getNome());
			this.setDescricao(source.getDescricao());
			this.setTamanho(source.getTamanho());
			this.setTipo(source.getTipo());
			this.setProduto(source.getProduto());
		}
	}
	
	public FotoEntity clone() {
		return clone(new java.util.HashMap<>());
	}
	
	public FotoEntity clone(java.util.Map<Object, Object> visited) {
		if (visited.containsKey(this)) {
			return (FotoEntity) visited.get(this);
		}
				
		FotoEntity theClone = new FotoEntity();
		visited.put(this, theClone);
		
		theClone.setId(this.getId());
		theClone.setNome(this.getNome());
		theClone.setDescricao(this.getDescricao());
		theClone.setTamanho(this.getTamanho());
		theClone.setTipo(this.getTipo());
		theClone.setProduto(this.getProduto() != null ? this.getProduto().clone(visited) : null);
		
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
		FotoEntity other = (FotoEntity) obj;
			
		
		// Field: id
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id))
			return false;
		
		// Field: nome
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome))
			return false;
		
		// Field: descricao
		if (descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!descricao.equals(other.descricao))
			return false;
		
		// Field: tamanho
		if (tamanho == null) {
			if (other.tamanho != null) {
				return false;
			}
		} else if (!tamanho.equals(other.tamanho))
			return false;
		
		// Field: tipo
		if (tipo == null) {
			if (other.tipo != null) {
				return false;
			}
		} else if (!tipo.equals(other.tipo))
			return false;
		
		// Field: produto
		if (produto == null) {
			if (other.produto != null) {
				return false;
			}
		} else if (produto.getId() == null) {
			if (other.produto.getId() != null)
				return false;
		} else if (!produto.getId().equals(other.produto.getId())) 
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
