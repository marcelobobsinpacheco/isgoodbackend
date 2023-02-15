package br.com.fiap.isGoodBackEndProducts.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="favoritos")
public class Favorito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer idFavoritos;
	
	@JoinColumn(name="id_usuario")
	@ManyToOne
	private Usuario cliente;
	
	@JoinColumn(name="id_produto")
	@ManyToOne
	private Produto produto;
	
	@Column(name="ordem")
	private Integer ordem;
	
	public Favorito() {}
	public Favorito(Usuario cliente, Produto produto, Integer ordem) {
		setCliente(cliente);
		setProduto(produto);
		setOrdem(ordem);
	}


	@Override
	public String toString() {
		return idFavoritos + " - " + cliente + ": " + produto;
	}
	public Integer getIdFavoritos() {
		return idFavoritos;
	}
	public void setIdFavoritos(Integer idFavoritos) {
		this.idFavoritos = idFavoritos;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

}
