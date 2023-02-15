package br.com.fiap.isGoodBackEndProducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.isGoodBackEndProducts.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
