package br.com.fiap.InventarioWeb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.InventarioWeb.models.Fornecedor;
import br.com.fiap.InventarioWeb.repository.FornecedorRepository;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> getAllFornecedores() {
        return repository.findAll();
    }

    public Optional<Fornecedor> getFornecedorById(Long id) {
        return repository.findById(id);
    }

    public Fornecedor saveFornecedor(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public void deleteFornecedor(Long id) {
        repository.deleteById(id);
    }

    public Fornecedor updateFornecedor(Long id, Fornecedor updateFornecedor) {
        Optional<Fornecedor> fornecedorOptional = repository.findById(id);

        if (fornecedorOptional.isPresent()) {
            Fornecedor fornecedor = fornecedorOptional.get();
            fornecedor.setNome(updateFornecedor.getNome());
            fornecedor.setEndereco(updateFornecedor.getEndereco());

            return repository.save(fornecedor);
        } else {
            throw new RuntimeException("Fornecedor não encontrado com o ID: "  + id);
        }
    }
}
