package com.example.desafioitaubackend.service.impl;

import com.example.desafioitaubackend.repository.TransacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoServiceImplTest {

    @Mock
    private TransacaoRepository transacaoRepository;

    @InjectMocks
    private TransacaoServiceImpl transacaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void realizarTransacao() {

    }

    @Test
    void removerTrasacoes() {
    }

    @Test
    void getTransacoes() {
    }
}