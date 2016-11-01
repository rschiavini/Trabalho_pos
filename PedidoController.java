package br.edu.utfpr.spring.trab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.spring.trab.model.Pedido;
import br.edu.utfpr.spring.trab.model.Produto;
import br.edu.utfpr.spring.trab.repository.PedidoRepository;
import br.edu.utfpr.spring.trab.repository.ProdutoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	// @Autowired
	// private UsuarioLogado usuarioLogado;

	@GetMapping("/")
	public String listaPedidoAberto(Model model) {
		List<Produto> produtos = produtoRepository.findAllEager();
		model.addAttribute("produtos", produtos);

		Pedido ped = pedidoRepository.GetUltimoPedidoAberto();
		model.addAttribute("pedido", ped);

		// usuarioLogado.get().ifPresent(usuario->{
		// model.addAttribute("nomeUsuario", usuario.getNome());
		// });
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		return "/pedido/pedido";

	}

}