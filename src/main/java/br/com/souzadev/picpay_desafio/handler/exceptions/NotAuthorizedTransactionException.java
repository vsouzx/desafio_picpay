package br.com.souzadev.picpay_desafio.handler.exceptions;

public class NotAuthorizedTransactionException extends Exception{

    public NotAuthorizedTransactionException() {
        super("Transacao nao autorizada");
    }
}
