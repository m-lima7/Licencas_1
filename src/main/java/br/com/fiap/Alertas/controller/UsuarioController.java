package br.com.fiap.Alertas.controller;

import br.com.fiap.Alertas.model.Usuario;
import br.com.fiap.Alertas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Usuario savedUser = usuarioRepository.save(usuario);
        return ResponseEntity.status(201).body(savedUser);
    }


    // List all users
    @GetMapping
    public ResponseEntity<List<Usuario>> listAllUsers() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }
}