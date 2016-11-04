package br.edu.utfpr.spring.trab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.spring.trab.consts.StatusPedido;
import br.edu.utfpr.spring.trab.model.Pedido;
import br.edu.utfpr.spring.trab.model.PedidoItem;
import br.edu.utfpr.spring.trab.model.Produto;
import br.edu.utfpr.spring.trab.repository.PedidoItemRepository;
import br.edu.utfpr.spring.trab.repository.PedidoRepository;
import br.edu.utfpr.spring.trab.repository.ProdutoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	@GetMapping("/")
	public String listaPedidoAberto(Model model) {
		List<Produto> produtos = produtoRepository.findAllEager();
		model.addAttribute("produtos", produtos);

		Pedido ped = pedidoRepository.getUltimoPedidoAberto();

		if (ped == null) {
			ped = new Pedido();
			ped.setStatus(StatusPedido.ABERTO.getTipoStatusNome());
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName(); // get logged in username
			ped.setUsuario(name);

			pedidoRepository.save(ped);
		}

		
		Double valorTotal = pedidoItemRepository.getValorTotalPedido(ped);
		model.addAttribute("valorTotal", valorTotal);

		return "/pedido/pedido";
	}

	@GetMapping("/adicionarProduto/{codigo}")
	public String adicionarProduto(@PathVariable Long codigo, Model model) {
		Produto produto = produtoRepository.findOne(codigo);

		// não existem método com letra maiúscula em java
		Pedido ped = pedidoRepository.getUltimoPedidoAberto();

		PedidoItem pedItem = new PedidoItem();
		pedItem.setPedido(ped);
		pedItem.setProduto(produto);
		pedItem.setValorItem(produto.getValor());
		pedidoItemRepository.save(pedItem);

		return "redirect:/pedido/";
	}

	@GetMapping("/cancelarPedido")
	public String cancelarPedido(final RedirectAttributes redirectAttributes) {

		Pedido ped = pedidoRepository.getUltimoPedidoAberto();

		pedidoItemRepository.deletaItensPedido(ped);
		pedidoRepository.delete(ped);
		redirectAttributes.addFlashAttribute("pedidoCancelado", "Pedido Cancelado com sucesso!!!");

		return "redirect:/pedido/";
	}

	@GetMapping("/AtualizaStatusPedidoFechado")
	public String atualizaStatusPedidoFechado(final RedirectAttributes redirectAttributes){
	
		Pedido ped = pedidoRepository.getUltimoPedidoAberto();
		if (ped != null) {
			ped.setStatus(StatusPedido.FINALIZADO.getTipoStatusNome());
			pedidoRepository.save(ped);		
			redirectAttributes.addFlashAttribute("pedidoFinalizado", "True");			
		}else{
			redirectAttributes.addFlashAttribute("pedidoFinalizado", "False");
		}
		
		
		return "redirect:/pedido/";
	}

}