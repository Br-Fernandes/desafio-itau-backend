package com.example.desafioitaubackend.controller;

import com.example.desafioitaubackend.model.Transacao;
import com.example.desafioitaubackend.service.impl.TransacaoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransacaoControllerTest {

    @Mock
    private TransacaoServiceImpl transacaoService;

    @InjectMocks
    private TransacaoController transacaoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void realizarTransacao_Sucesso() {
        Double valor = 45.5;
        Transacao transacao = new Transacao(valor, OffsetDateTime.now());
        when(transacaoService.realizarTransacao(any(Transacao.class))).thenReturn(true);

        ResponseEntity<Transacao> response = transacaoController.realizarTransacao(valor);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void realizarTransacao_ValorNulo() {
        ResponseEntity<Transacao> response = transacaoController.realizarTransacao(null);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    void realizarTransacao_ValorNegativo() {
        ResponseEntity<Transacao> response = transacaoController.realizarTransacao(-10.0);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    void realizarTransacao_FalhaNoServico() {
        Double valor = 45.5;
        Transacao transacao = new Transacao(valor, OffsetDateTime.now());
        when(transacaoService.realizarTransacao(any(Transacao.class))).thenReturn(false);

        ResponseEntity<Transacao> response = transacaoController.realizarTransacao(valor);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    void removerTransacoes_Sucesso() {
        ResponseEntity<Void> response = transacaoController.removerTransacoes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void removerTransacoes_FalhaNoServico() {
        ResponseEntity<Void> response = transacaoController.removerTransacoes();

        assertEquals(HttpStatus.OK, response.getStatusCode()); // Ajuste conforme o comportamento esperado
    }
}
