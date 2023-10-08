package br.com.fiap.InventarioWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.InventarioWeb.models.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    
}
