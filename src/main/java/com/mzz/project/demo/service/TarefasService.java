package com.mzz.project.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mzz.project.demo.excecoes.TarefaNaoEncontradaException;
import com.mzz.project.demo.excecoes.UsuarioNaoEncontradoException;
import com.mzz.project.demo.model.Tarefas;
import com.mzz.project.demo.model.Usuario;
import com.mzz.project.demo.repository.TarefasRepository;
import com.mzz.project.demo.repository.UsuarioRepository;


@Service
public class TarefasService {
     private TarefasRepository tarefasRepository;
     private UsuarioRepository usuarioRepository;

    public TarefasService(TarefasRepository tarefasRepository, UsuarioRepository usuarioRepository){
        this.tarefasRepository = tarefasRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Tarefas> listarTarefas(){
        return tarefasRepository.findAll();
    }
    public Tarefas salvaTarefaPorUsuario(Tarefas tarefa, Long usuarioId) {
    Usuario usuario = usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));

    tarefa.setUsuario(usuario); 
    return tarefasRepository.save(tarefa);
}

    // public Tarefas salvaTarefa(Tarefas tarefa){
    //     return  tarefasRepository.save(tarefa);
    // }

    public Tarefas buscarTarefaPorId(Long id){
        return tarefasRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario com ID"+id+"não encontrado"));
    }

    public void deletaTarefaPorId(Long id){
        if(!tarefasRepository.existsById(id)){
            throw new TarefaNaoEncontradaException("Usuario com ID"+id+"não encontrado");
        }
        tarefasRepository.deleteById(id);
    }
}
