package br.com.souzadev.picpay_desafio.handler.exceptions;

public class InsuficientBalanceException extends Exception{

    public InsuficientBalanceException() {
        super("Saldo insuficiente");
    }
}
