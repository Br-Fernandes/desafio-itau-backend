package com.example.desafioitaubackend.controller;

import com.example.desafioitaubackend.service.impl.EstatisticaServiceImpl;
import com.example.desafioitaubackend.service.impl.TransacaoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class EstatisticaControllerTest {

    @Mock
    private EstatisticaServiceImpl estatisticaService;

    @InjectMocks
    private EstatisticaController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void calcularEstatistica() {

    }

    @Test
    void testCalcularEstatistica() {
    }
}