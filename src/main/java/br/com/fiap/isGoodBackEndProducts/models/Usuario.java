package br.com.fiap.isGoodBackEndProducts.models;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer idUsuario;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="cep")
	private String cep;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro")
	private Calendar dhCadastro;
	
	@OneToMany(mappedBy="usuario_owner")
	private Collection<Empresa> empresas;
	
	@OneToMany(mappedBy="cliente")
	@JsonManagedReference
	private Collection<Avaliacao> avaliacoes;
	public Usuario(String nome, String email, String senha, String cep) {
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setCep(cep);
	}
	public Usuario() {}

	
	public Collection<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(Collection<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public Collection<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(Collection<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Calendar getDhCadastro() {
		return dhCadastro;
	}
	public void setDhCadastro(Calendar dhCadastro) {
		this.dhCadastro = dhCadastro;
	}
	
	@Override
	public String toString() {
		return ((idUsuario==null) ? "" : idUsuario) + " - " + nome;
	}

}
