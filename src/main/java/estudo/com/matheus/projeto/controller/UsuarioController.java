package estudo.com.matheus.projeto.controller;

import estudo.com.matheus.projeto.entity.UsuarioEntity;
import estudo.com.matheus.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioEntity criarUsuario(@RequestBody UsuarioEntity usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioEntity atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuarioAtualizado) {
        return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }

    @GetMapping("/{id}")
    public UsuarioEntity buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @GetMapping
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}