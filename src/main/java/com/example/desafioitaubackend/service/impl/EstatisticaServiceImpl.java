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
        Map<String, Number> estatistica = new LinkedHashMap<>();
        List<Transacao> trasacoesFiltradas = filtrarTransacao(transacaoService.getTransacoes(), 60);

        DoubleSummaryStatistics stats = trasacoesFiltradas.stream()
                        .mapToDouble(Transacao::getValor)
                                .summaryStatistics();

        estatistica.put("count", stats.getCount());
        estatistica.put("sum", stats.getSum());
        estatistica.put("avg", stats.getAverage());
        estatistica.put("min", stats.getMin());
        estatistica.put("max", stats.getMax());

        return estatistica;
    }

    @Override
    public List<Transacao> filtrarTransacao(List<Transacao> transacoes, int segundos) {
        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime limite = agora.minusSeconds(segundos);

        return transacoes.stream()
                .filter(transacao -> transacao.getDataHora().isAfter(limite))
                .collect(Collectors.toList());
    }
}
