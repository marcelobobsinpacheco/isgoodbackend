package br.com.fiap.isGoodBackEndProducts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.isGoodBackEndProducts.models.Produto;
import br.com.fiap.isGoodBackEndProducts.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(maxAge = 3600)
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/listar")
	public List<Produto> listar () {
		List<Produto> listProdutos = produtoRepository.findAll();
		return listProdutos;
	}
}
