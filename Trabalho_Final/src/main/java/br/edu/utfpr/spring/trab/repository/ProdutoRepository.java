package br.edu.utfpr.spring.trab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.utfpr.spring.trab.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByNomeLike(String nome);

	@Query("select distinct p from Produto p")
	List<Produto> findAllEager();

}
