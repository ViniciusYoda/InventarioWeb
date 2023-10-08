package br.com.fiap.InventarioWeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.InventarioWeb.models.Produto;
import br.com.fiap.InventarioWeb.services.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return service.getAllProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        return ResponseEntity.of(service.getProdutoById(id));
    }

    @PostMapping
    public Produto createProduto(@Valid @RequestBody Produto produto) {
        return service.saveProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id, @Valid @RequestBody Produto updateProduto) {
        return service.updateProduto(id, updateProduto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        service.deleteProduto(id);
    }
}
