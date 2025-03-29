package br.com.souzadev.picpay_desafio.handler.exceptions;

public class InternalErrorException extends Exception{

    public InternalErrorException(String url) {
        super(String.format("Houve um erro interno chamar a seguinte url %s", url));
    }
}
