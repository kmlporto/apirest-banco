package com.kamila.banco.util;

public class Path {
    public final static String ID = "/{id}";
    public final static String PESSOA = "/pessoas";
    public final static String CONTA = "/contas";
    public final static String TRANSACAO = "/transacoes";
    public final static String CONTA_TRANSACAO = CONTA + ID + TRANSACAO;
    public final static String SAQUE = "/saques";
    public final static String DEPOSITO = "/depositos";
}
