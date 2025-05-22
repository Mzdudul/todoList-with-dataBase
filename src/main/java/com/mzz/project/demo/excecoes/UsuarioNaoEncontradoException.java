package com.mzz.project.demo.excecoes;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
