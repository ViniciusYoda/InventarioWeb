package br.com.fiap.InventarioWeb.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import jakarta.persistence.Entity;
import jakarta.persistenece.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constrainst.Min;
import jakarta.validation.constrainst.NotEmpty;

@Entity
@Data
@NotArgsConstructor
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