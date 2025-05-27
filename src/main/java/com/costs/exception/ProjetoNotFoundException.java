package com.costs.exception;

public class ProjetoNotFoundException extends RuntimeException{

    public ProjetoNotFoundException() {
        super("Projeto não encontrado.");
    }

    public ProjetoNotFoundException(String message) {
        super(message);
    }
}
