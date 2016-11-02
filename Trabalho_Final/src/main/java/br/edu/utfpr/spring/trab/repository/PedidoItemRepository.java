package br.edu.utfpr.spring.trab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.spring.trab.model.Pedido;
import br.edu.utfpr.spring.trab.model.PedidoItem;

public interface PedidoItemRepository  extends JpaRepository<PedidoItem, Long> {

	@Query("select sum(p.valorItem) from PedidoItem p where p.pedido = ?1")
	Double getValorTotalPedido(Pedido pedido);
	//Diz para o Spring que não é um método de consulta, mas sim um método que irá modificar os dados
	@Modifying
	//Deixa na mesma transação do Pedido
	@Transactional
	@Query("delete from PedidoItem p where p.pedido = ?1")
	void deletaItensPedido(Pedido pedido);

}
