package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.Pagamento;

import java.time.Instant;

public class PagamentoDTO {

    private Long  pagamentoId;
    private Instant momento;

    public PagamentoDTO(Long pagamentoId, Instant momento) {
        this.pagamentoId = pagamentoId;
        this.momento = momento;
    }

    public PagamentoDTO() {
    }

    public PagamentoDTO(Pagamento entity){
        pagamentoId = entity.getId();
        momento = entity.getMomento();
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Long getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

}
