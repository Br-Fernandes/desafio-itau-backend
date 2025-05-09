package com.example.desafioitaubackend.service;

import com.example.desafioitaubackend.model.Transacao;

import java.util.List;

public interface TransacaoService {

    public boolean realizarTransacao(Transacao transacao);

    public void removerTrasacoes();

    public List<Transacao> getTransacoes();

}
