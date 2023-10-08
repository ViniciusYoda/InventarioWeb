package br.com.fiap.InventarioWeb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.InventarioWeb.models.Produto;
import br.com.fiap.InventarioWeb.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return repository.findById(id);
    }

    public Produto saveProduto(Produto produto) {
        return repository.save(produto);
    }

    public void deleteProduto(Long id) {
        repository.deleteById(id);
    }

    public Produto updateProduto(Long id, Produto updateProduto) {
        Optional<Produto> produtoOptional = repository.findById(id);

        if(produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setNome(updateProduto.getNome());
            produto.setDescricao(updateProduto.getDescricao());
            produto.setPreco(updateProduto.getPreco());
            produto.setQuantidadeEmEstoque(updateProduto.getQuantidadeEmEstoque());
            produto.setFornecedor(updateProduto.getFornecedor());

            return repository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: "  + id);
        }
    }
}
