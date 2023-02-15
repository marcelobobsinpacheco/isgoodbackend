package br.com.fiap.isGoodBackEndProducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.isGoodBackEndProducts.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
}
