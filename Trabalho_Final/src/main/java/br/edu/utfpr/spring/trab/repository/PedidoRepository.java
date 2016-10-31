package br.edu.utfpr.spring.trab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.utfpr.spring.trab.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("select p from Pedido p where p.status='Aberto'")
	Pedido GetUltimoPedidoAberto();
	

}
