package br.edu.utfpr.spring.trab.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PedidoItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;
	
	private Double valorItem;
	

}