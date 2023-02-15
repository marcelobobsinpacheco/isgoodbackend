package br.com.fiap.isGoodBackEndProducts.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="avaliacao")
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@JoinColumn(name="id_cliente")
	@ManyToOne
	@JsonBackReference
	private Usuario cliente;
	
	@JoinColumn(name="id_produto")
	@ManyToOne
	@JsonBackReference
	private Produto produto;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="descricao")
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data")
	private Calendar data;
	
	public Avaliacao() {}
	public Avaliacao(Usuario cliente, Produto produto, Integer rating, String descricao) {
		setCliente(cliente);
		setProduto(produto);
		setRating(rating);
		setDescricao(descricao);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}
	
	public String getDataFormated() {
		if (data==null) return "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(data.getTime());
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		return (getDataFormated()) + " - " + cliente + ": [" + rating + "]";
	}

}
