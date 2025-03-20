package estudo.com.matheus.projeto.service;

import estudo.com.matheus.projeto.entity.UsuarioEntity;
import estudo.com.matheus.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
        // Adicione validações ou lógica de negócios aqui, se necessário
        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity atualizarUsuario(Long id, UsuarioEntity usuarioAtualizado) {
        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuarioAtualizado.setId(id); // Garante que o ID não seja alterado
            return usuarioRepository.save(usuarioAtualizado);
        }
        return null; // Ou lance uma exceção indicando que o usuário não foi encontrado
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioEntity buscarUsuarioPorId(Long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null); // Retorna null se o usuário não for encontrado
    }

    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity buscarUsuarioPorLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioEntity buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
}