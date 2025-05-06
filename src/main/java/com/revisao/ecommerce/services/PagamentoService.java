package com.revisao.ecommerce.services;

import com.revisao.ecommerce.dto.PagamentoDTO;
import com.revisao.ecommerce.entities.Pagamento;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.StatusDoPedido;
import com.revisao.ecommerce.repositories.PagamentoRepository;
import com.revisao.ecommerce.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    public Pedido alterarPagamento(Long id){
        Pagamento pagamento = pagamentoRepository.findById(id).get();
        if(pagamento.getPedido() != null){
            pagamento.getPedido().setStatus(StatusDoPedido.PAGO);
            //pagamentoRepository.save(pagamento);
            Pedido pedido = pedidoRepository.findById(id).get();
            return pedido;
        }
        else  return null;
    }
}
