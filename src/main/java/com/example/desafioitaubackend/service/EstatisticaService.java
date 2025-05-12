package com.example.desafioitaubackend.service;

import com.example.desafioitaubackend.model.Transacao;

import java.util.List;
import java.util.Map;

public interface EstatisticaService {

    public Map<String, Number> calcularEstatistica();

    public Map<String, Number> calcularEstatistica(int segundos);

    public List<Transacao> filtrarTransacao(List<Transacao> transacoes, int segundos);

}
