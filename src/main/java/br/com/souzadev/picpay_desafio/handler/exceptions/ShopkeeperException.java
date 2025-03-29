package br.com.souzadev.picpay_desafio.handler.exceptions;

public class ShopkeeperException extends Exception{

    public ShopkeeperException(Integer userId) {
        super(String.format("O usuario %s é lojista e nao pode realizar transacoes", userId));
    }
}
