package com.mzz.project.demo.excecoes;

public class UsuarioOuTarefaNaoEncontradoException extends RuntimeException {
    public UsuarioOuTarefaNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
