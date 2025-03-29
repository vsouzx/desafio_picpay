package br.com.souzadev.picpay_desafio.handler.exceptions;

public class CpfAlreadyExistsException extends Exception{

    public CpfAlreadyExistsException(String cpf) {
        super(String.format("Você não pode usar este cpf %s", cpf));
    }
}
