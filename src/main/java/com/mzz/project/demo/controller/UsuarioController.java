package com.mzz.project.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzz.project.demo.excecoes.UsuarioNaoEncontradoException;
import com.mzz.project.demo.model.Usuario;
import com.mzz.project.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping()
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvaUsuario(usuario);
    }

    @GetMapping()
    public List<Usuario> buscarUsuarios() {
        return usuarioService.listarUsuario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id) {
        try{
            Usuario usuario = usuarioService.buscaPorId(id);
            return ResponseEntity.ok(usuario);
        }catch(UsuarioNaoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaUsuarioPorId(@PathVariable Long id) {
        usuarioService.deletaUsuarioPorId(id);
        return ResponseEntity.noContent().build();
        
    }
    
    
    
    
} 