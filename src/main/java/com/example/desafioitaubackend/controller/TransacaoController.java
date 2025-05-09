package com.example.desafioitaubackend.controller;

import com.example.desafioitaubackend.model.Transacao;
import com.example.desafioitaubackend.service.impl.TransacaoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/v1")
public class TransacaoController {

    public final TransacaoServiceImpl transacaoService;

    public TransacaoController(TransacaoServiceImpl transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Transacao> realizarTransacao(@RequestBody Double valor) {
        Transacao transacao = new Transacao(valor, OffsetDateTime.now());

        if (transacaoService.realizarTransacao(transacao)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Void> removerTransacoes() {
        transacaoService.removerTrasacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
