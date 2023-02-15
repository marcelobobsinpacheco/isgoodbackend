package br.com.fiap.isGoodBackEndProducts.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@JsonProperty
	private Integer id;
	
	@Column(name="nome")
	@JsonProperty
	private String nome;
	
	@JoinColumn(name="id_empresa")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonProperty
	@JsonManagedReference
	private Empresa empresa;
	
	@Column(name="descricao")
	@JsonProperty
	private String descricao;
	
	@Column(name="foto")
	@JsonProperty
	private String foto;
	
	@Column(name="rating")
	@JsonProperty
	private Integer rating;
	
	@Column(name="exibir")
	@JsonProperty
	private Boolean boExibir;
	
	@OneToMany(mappedBy = "produto")
	@JsonProperty
	@JsonManagedReference
	private List<Avaliacao> avaliacoes;
	
	public Produto() { }
	public Produto(Empresa empresa, String nome, String descricao, Boolean boExibir) {
		setEmpresa(empresa);
		setNome(nome);
		setDescricao(descricao);
		setBoExibir(boExibir);
	}
	public Produto(Empresa empresa, String nome, String descricao, Integer rating, String foto) {
		this(empresa,nome,descricao, true);
		this.setRating(rating);
		this.foto = foto;
	}

	

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getBoExibir() {
		return boExibir;
	}

	public void setBoExibir(Boolean boExibir) {
		this.boExibir = boExibir;
	}
	
	@Override
	public String toString() {
		return ((getId()==null) ? "" : getId()+"") + " - " + nome; 
	}
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
