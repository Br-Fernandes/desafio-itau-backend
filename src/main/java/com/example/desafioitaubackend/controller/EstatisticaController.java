package com.example.desafioitaubackend.controller;

import com.example.desafioitaubackend.service.impl.EstatisticaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EstatisticaController {

    private final EstatisticaServiceImpl estatisticaService;

    public EstatisticaController(EstatisticaServiceImpl estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping("/estatistica")
    public ResponseEntity<Map<String, Number>> calcularEstatistica(){
        return ResponseEntity.ok(estatisticaService.calcularEstatistica());
    }

    @GetMapping("/estatistica/{segundos}")
    public ResponseEntity<Map<String, Number>> calcularEstatistica(@PathVariable int segundos) {
        return ResponseEntity.ok(estatisticaService.calcularEstatistica(segundos));
    }
}
