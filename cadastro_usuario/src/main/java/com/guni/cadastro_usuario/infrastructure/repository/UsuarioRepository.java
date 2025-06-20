package com.guni.cadastro_usuario.infrastructure.repository;

// Importa a entidade que representa os dados do usuário
import com.guni.cadastro_usuario.infrastructure.entitys.Usuario;

// Anotação que gerencia a transação para o método customizado de exclusão
import jakarta.transaction.Transactional;

// Interface base do Spring Data JPA que fornece métodos prontos como save, findById, delete, etc.
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repositório responsável pelo acesso aos dados da entidade Usuario
// Estende JpaRepository com a entidade Usuario e tipo da chave primária Integer
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Método customizado para buscar um usuário por e-mail
    // Retorna um Optional para lidar com valores que podem ser nulos
    Optional<Usuario> findByEmail(String email);

    // Método customizado para deletar um usuário pelo e-mail
    // Anotado com @Transactional para garantir que a operação de exclusão seja executada dentro de uma transação
    @Transactional
    void deleteByEmail(String email);
}
