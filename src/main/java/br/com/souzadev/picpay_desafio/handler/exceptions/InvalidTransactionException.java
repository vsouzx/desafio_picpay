package br.com.souzadev.picpay_desafio.handler.exceptions;

public class InvalidTransactionException extends Exception{

    public InvalidTransactionException() {
        super("Sender e receiver não podem ser o mesmo");
    }
}
