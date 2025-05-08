package com.example.desafioitaubackend.repository;

import com.example.desafioitaubackend.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    public List<Transacao> transacoes = new ArrayList<>();

}
