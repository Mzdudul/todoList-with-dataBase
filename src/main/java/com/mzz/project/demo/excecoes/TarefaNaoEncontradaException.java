package com.mzz.project.demo.excecoes;

public class TarefaNaoEncontradaException extends RuntimeException {
    public TarefaNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
