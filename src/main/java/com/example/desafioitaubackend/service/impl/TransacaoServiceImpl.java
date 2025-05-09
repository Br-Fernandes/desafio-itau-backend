package com.example.desafioitaubackend.service.impl;

import com.example.desafioitaubackend.model.Transacao;
import com.example.desafioitaubackend.repository.TransacaoRepository;
import com.example.desafioitaubackend.service.TransacaoService;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    public final TransacaoRepository transacaoRepository;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public boolean realizarTransacao(Transacao transacao) {
        if (transacao.getValor() < 0) {
            return false;
        }
        if (transacao.getDataHora().isAfter(OffsetDateTime.now())){
            return false;
        }

        transacaoRepository.transacoes.add(transacao);
        return true;
    }

    @Override
    public void removerTrasacoes() {
        transacaoRepository.transacoes.clear();
    }

    @Override
    public List<Transacao> getTransacoes() {
        return transacaoRepository.transacoes;
    }
}
