package com.revisao.ecommerce.controllers;

import com.revisao.ecommerce.services.PagamentoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @PutMapping("/updt/{id}")
    @Transactional
    public ResponseEntity<?> atualizarPagamento(@PathVariable Long id){
        return ResponseEntity.ok(pagamentoService.alterarPagamento(id));
    }
}
