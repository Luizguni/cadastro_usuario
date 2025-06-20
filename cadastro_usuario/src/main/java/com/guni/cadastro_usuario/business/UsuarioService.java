package com.guni.cadastro_usuario.business;

// Importa a entidade Usuario que representa os dados do usuário no banco
import com.guni.cadastro_usuario.infrastructure.entitys.Usuario;

// Importa o repositório responsável pelo acesso aos dados do usuário
import com.guni.cadastro_usuario.infrastructure.repository.UsuarioRepository;

// Indica que esta classe é um componente de serviço do Spring (camada de negócio)
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    // Injeção do repositório para acesso aos dados persistidos no banco
    private final UsuarioRepository repository;

    // Construtor com injeção de dependência (padrão no Spring)
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Método responsável por salvar um novo usuário no banco de dados
    public void salvarUsuario(Usuario usuario) {
        // saveAndFlush salva e força a escrita imediata no banco
        repository.saveAndFlush(usuario);
    }

    // Método que busca um usuário pelo e-mail informado
    public Usuario buscarUsuarioPorEmail(String email) {
        // Busca o usuário no banco. Se não encontrar, lança uma exceção
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    // Método responsável por deletar um usuário com base no e-mail
    public void deletarUsuarioPorEmail(String email) {
        // Deleta diretamente usando a query personalizada no repositório
        repository.deleteByEmail(email);
    }

    // Método responsável por atualizar os dados de um usuário com base no ID
    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        // Busca o usuário original no banco. Se não encontrar, lança uma exceção
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));

        // Constrói um novo objeto com os dados atualizados. Se algum campo estiver nulo,
        // mantém o valor original
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() :
                        usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() :
                        usuarioEntity.getNome())
                .id(usuarioEntity.getId()) // Mantém o ID original
                .build();

        // Salva o usuário atualizado no banco
        repository.saveAndFlush(usuarioAtualizado);
    }
}
