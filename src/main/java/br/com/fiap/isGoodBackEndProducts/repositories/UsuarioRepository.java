package br.com.fiap.isGoodBackEndProducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.isGoodBackEndProducts.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
