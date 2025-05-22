package com.mzz.project.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mzz.project.demo.excecoes.UsuarioNaoEncontradoException;
import com.mzz.project.demo.model.Usuario;
import com.mzz.project.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario salvaUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscaPorId(Long id){
        return (Usuario) usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario com ID"+id+"não encontrado"));
    }

    public void deletaUsuarioPorId(Long id){
        if(!usuarioRepository.existsById(id)){
            throw new UsuarioNaoEncontradoException("Usuario com ID"+id+"não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
