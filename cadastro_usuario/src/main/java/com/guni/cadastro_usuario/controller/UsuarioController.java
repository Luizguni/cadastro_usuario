package com.guni.cadastro_usuario.controller;

// Importa o serviço responsável pela lógica de negócio relacionada ao usuário
import com.guni.cadastro_usuario.business.UsuarioService;

// Importa a entidade que representa o modelo de dados do usuário
import com.guni.cadastro_usuario.infrastructure.entitys.Usuario;

// Lombok: gera automaticamente o construtor com os atributos final
import lombok.RequiredArgsConstructor;

// Spring: usado para criar respostas HTTP padronizadas
import org.springframework.http.ResponseEntity;

// Spring: fornece suporte para REST e mapeamento de requisições HTTP
import org.springframework.web.bind.annotation.*;

// Define que esta classe é um controller REST (camada que recebe as requisições)
@RestController

// Define o caminho base para todos os endpoints deste controller: /usuario
@RequestMapping("/usuario")

// Lombok: gera o construtor apenas com os campos marcados como final
@RequiredArgsConstructor
public class UsuarioController {

    // Injeção de dependência do serviço de usuário
    private final UsuarioService usuarioService;

    // Endpoint para criar (salvar) um novo usuário
    // Exemplo: POST /usuario com o corpo JSON do usuário
    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build(); // Retorna status 200 OK sem corpo
    }

    // Endpoint para buscar um usuário pelo e-mail
    // Exemplo: GET /usuario?email=teste@email.com
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    // Endpoint para deletar um usuário usando o e-mail como identificador
    // Exemplo: DELETE /usuario?email=teste@email.com
    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build(); // Retorna status 200 OK sem corpo
    }

    // Endpoint para atualizar os dados de um usuário com base no ID
    // Exemplo: PUT /usuario?id=1 com o corpo JSON do usuário atualizado
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id, @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build(); // Retorna status 200 OK sem corpo
    }
}
