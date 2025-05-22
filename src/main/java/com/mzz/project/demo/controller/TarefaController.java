package com.mzz.project.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzz.project.demo.excecoes.UsuarioNaoEncontradoException;
import com.mzz.project.demo.model.Tarefas;
import com.mzz.project.demo.service.TarefasService;


@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
    private final TarefasService tarefasService;

    TarefaController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @PostMapping("/usuario/{id}")
    public Tarefas criarTarefa(@RequestBody Tarefas tarefa, @PathVariable Long id) {
        return tarefasService.salvaTarefaPorUsuario(tarefa, id);
    }

    @GetMapping()
    public List<Tarefas> buscarTarefas() {
        return tarefasService.listarTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaTarefaPorId(@PathVariable Long id) {
        try{
            Tarefas tarefas = tarefasService.buscarTarefaPorId(id);
            return ResponseEntity.ok(tarefas);
        }catch(UsuarioNaoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaTarefa(@PathVariable Long id) {
        tarefasService.deletaTarefaPorId(id);
        return ResponseEntity.noContent().build();
        
    }
}
