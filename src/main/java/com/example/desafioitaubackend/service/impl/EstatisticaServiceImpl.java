package com.example.desafioitaubackend.service.impl;

import com.example.desafioitaubackend.model.Transacao;
import com.example.desafioitaubackend.service.EstatisticaService;
import com.example.desafioitaubackend.service.TransacaoService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EstatisticaServiceImpl implements EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaServiceImpl(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @Override
    public Map<String, Number> calcularEstatistica() {
        return calcularEstatistica(60);
    }

    @Override
    public Map<String, Number> calcularEstatistica(int segundos) {
        List<Transacao> trasacoesFiltradas = filtrarTransacao(transacaoService.getTransacoes(), segundos);

        if (trasacoesFiltradas.isEmpty()){
            return criarEstatisticasVazias();
        }

        DoubleSummaryStatistics stats = trasacoesFiltradas.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        return Map.of(
                "count", stats.getCount(),
                "sum", stats.getSum(),
                "avg", stats.getAverage(),
                "min", stats.getMin(),
                "max", stats.getMax()
        );
    }

    private Map<String, Number> criarEstatisticasVazias() {
        return Map.of(
                "count", 0,
                "sum", 0,
                "avg", 0,
                "min", 0,
                "max", 0
        );
    }

    @Override
    public List<Transacao> filtrarTransacao(List<Transacao> transacoes, int segundos) {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(segundos);

        return transacoes.stream()
                .filter(transacao -> transacao.getDataHora().isAfter(limite))
                .collect(Collectors.toList());
    }
}
