package com.example.desafioitaubackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Transacao {

    private UUID id;

    private Double valor;
    private OffsetDateTime dataHora;

    public Transacao(Double valor, OffsetDateTime dataHora) {
        gerarId();
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public void gerarId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
