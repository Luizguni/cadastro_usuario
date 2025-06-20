package com.guni.cadastro_usuario.infrastructure.entitys;

// Importa anotações JPA para mapear a entidade ao banco de dados
import jakarta.persistence.*;

// Importa anotações do Lombok para gerar automaticamente getters, setters e construtores
import lombok.*;


// Lombok: Gera os métodos getters e setters para todos os atributos
@Getter
@Setter

// Lombok: Gera um construtor com todos os argumentos
@AllArgsConstructor

// Lombok: Gera um construtor sem argumentos
@NoArgsConstructor

// Lombok: Permite criar objetos com o padrão de projeto "Builder"
@Builder

// Define o nome da tabela no banco de dados associada a essa entidade
@Table(name = "usuario")

// Indica que essa classe é uma entidade JPA (persistente no banco)
@Entity
public class Usuario {

    // Define o campo "id" como chave primária da entidade
    @Id

    // Gera o valor do ID automaticamente (auto incremento padrão do banco)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Define a coluna "email" na tabela, com restrição de valor único (unique)
    @Column(name = "email", unique = true)
    private String email;

    // Define a coluna "nome" na tabela
    @Column(name = "nome")
    private String nome;
}
