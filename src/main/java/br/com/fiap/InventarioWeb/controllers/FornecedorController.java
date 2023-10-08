package br.com.fiap.InventarioWeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.InventarioWeb.models.Fornecedor;
import br.com.fiap.InventarioWeb.services.FornecedorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @GetMapping
    public List<Fornecedor> getAllFornecedores() {
        return service.getAllFornecedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id) {
        return ResponseEntity.of(service.getFornecedorById(id));
    }

    @PostMapping
    public Fornecedor createFornecedor(@Valid @RequestBody Fornecedor fornecedor) {
        return service.saveFornecedor(fornecedor);
    }

    @PutMapping("/{id}")
    public Fornecedor updateFornecedor(@PathVariable Long id, @Valid @RequestBody Fornecedor updateFornecedor) {
        return service.updateFornecedor(id, updateFornecedor);
    }

    @DeleteMapping("/{id}")
    public void deleteFornecedor(@PathVariable Long id) {
        service.deleteFornecedor(id);
    }
}
