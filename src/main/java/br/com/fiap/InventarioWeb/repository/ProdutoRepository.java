package br.com.fiap.InventarioWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.InventarioWeb.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
