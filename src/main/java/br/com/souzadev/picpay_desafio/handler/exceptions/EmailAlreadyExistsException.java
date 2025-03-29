package br.com.souzadev.picpay_desafio.handler.exceptions;

public class EmailAlreadyExistsException extends Exception{

    public EmailAlreadyExistsException(String email) {
        super(String.format("Você não pode usar este email %s", email));
    }
}
