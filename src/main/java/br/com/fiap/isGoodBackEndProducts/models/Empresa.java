package br.com.fiap.isGoodBackEndProducts.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonProperty
	private Integer id;
	
	@Column(name="nome")
	@JsonProperty
	private String nome;
	
	@JoinColumn(name="id_usuario")
	@ManyToOne
	@JsonProperty
	@JsonBackReference
	private Usuario usuario_owner;
	
	@Column(name="endereco")
	@JsonProperty
	private String endereco;
	
	@Column(name="apresentacao")
	@JsonProperty
	private String apresentacao;
	
	@Column(name="cep")
	@JsonProperty
	private String cep;
	
	@Column(name="latitude")
	@JsonProperty
	private Double latitude;
	
	@Column(name="longitude")
	@JsonProperty
	private Double longitude;
	
	@Column(name="logo")
	@JsonProperty
	private String logo;
	
	@Column(name="rating")
	@JsonProperty
	private Integer rating;
	
	@Column(name="url_facebook")
	@JsonProperty
	private String url_facebook;

	@Column(name="url_twitter")
	@JsonProperty
	private String url_twitter;
	
	@Column(name="url_instagram")
	@JsonProperty
	private String url_instagram;
	
	@Column(name="url_tripadvisor")
	@JsonProperty
	private String url_tripadvisor;
	
	@OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
	@JsonBackReference
	private Collection<Produto> produtos;
	
	public Collection<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
	public Empresa() {}
	public Empresa(String nome, String apresentacao, Usuario usuario_owner, String endereco, String cep,
					String url_facebook, String url_twitter, String url_instagram,
					String url_tripadvisor, Double latitude, Double longitude, String logo, Integer rating) {
		setNome(nome);
		setUsuario_owner(usuario_owner);
		setEndereco(endereco);
		setCep(cep);
		setUrl_facebook(url_facebook);
		setUrl_instagram(url_instagram);
		setUrl_tripadvisor(url_tripadvisor);
		setUrl_twitter(url_twitter);
		this.apresentacao = apresentacao;
		this.latitude = latitude;
		this.longitude = longitude;
		this.logo=logo;
		this.rating = rating;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getUsuario_owner() {
		return usuario_owner;
	}
	public void setUsuario_owner(Usuario usuario_owner) {
		this.usuario_owner = usuario_owner;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getUrl_facebook() {
		return url_facebook;
	}
	public void setUrl_facebook(String url_facebook) {
		this.url_facebook = url_facebook;
	}
	public String getUrl_twitter() {
		return url_twitter;
	}
	public void setUrl_twitter(String url_twitter) {
		this.url_twitter = url_twitter;
	}
	public String getUrl_instagram() {
		return url_instagram;
	}
	public void setUrl_instagram(String url_instagram) {
		this.url_instagram = url_instagram;
	}
	public String getUrl_tripadvisor() {
		return url_tripadvisor;
	}
	public void setUrl_tripadvisor(String url_tripadvisor) {
		this.url_tripadvisor = url_tripadvisor;
	}
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return ((id==null) ? "" : id+"") + " - " + nome;
	}
	public String getApresentacao() {
		return apresentacao;
	}
	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}
	
}
