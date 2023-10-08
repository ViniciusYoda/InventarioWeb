package br.com.fiap.InventarioWeb.models;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import br.com.fiap.InventarioWeb.models.Fornecedor;

@Entity
@Table(name = "produto_dimdim")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do produto é obrigatório.")
    private String nome;

    private String descricao;

    @Min(value = 0, message = "O preço não pode ser negativo.")
    private double preco;

    @Min(value = 0, message = "A quantidade em estoque não pode ser negativo.")
    private int quantidadeEmEstoque;

    @ManyToOne
    private Fornecedor fornecedor;


}