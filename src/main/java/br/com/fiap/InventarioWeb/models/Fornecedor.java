package br.com.fiap.InventarioWeb.models;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

import br.com.fiap.InventarioWeb.models.Produto;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fornecedor {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do fornecedor é obrigatório.")
    private String nome;

    private String endereco;

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produto;
}