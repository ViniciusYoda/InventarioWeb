package br.com.fiap.InventarioWeb.models;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.*;
import java.util.List;

//import org.hibernate.annotations.IdGeneratorType;


@Entity
@Table(name = "fornecedor_dimdim")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fornecedor {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    private String telefone;

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produto;
}