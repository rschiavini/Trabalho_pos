package br.edu.utfpr.spring.trab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.spring.trab.model.Produto;
import br.edu.utfpr.spring.trab.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	

	@GetMapping("/")
	public String lista(Model model) {
		List<Produto> produtos = produtoRepository.findAllEager();
		model.addAttribute("produtos", produtos);

		return "/produto/lista";
	}

	@GetMapping("/pesquisa/{nome}")
	public String filtraPorNome(@PathVariable String nome, Model model) {
		List<Produto> produtos = produtoRepository.findByNomeLike(nome);
		model.addAttribute("produtos", produtos);
		return "/produto/lista";
	}

	@GetMapping("/{codigo}")
	public String visualizar(@PathVariable Long codigo, Model model) {
		Produto produto = produtoRepository.findOne(codigo);
		model.addAttribute("produto", produto);
		return "/produto/novo";
	}

}
