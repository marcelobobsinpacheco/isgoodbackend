package br.com.fiap.isGoodBackEndProducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.isGoodBackEndProducts.models.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>{
}
