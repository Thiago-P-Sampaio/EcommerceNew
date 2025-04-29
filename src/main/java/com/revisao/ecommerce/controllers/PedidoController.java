package com.revisao.ecommerce.controllers;


import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("order")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;


    @PostMapping ( value = "/new")
    public ResponseEntity<PedidoDTO> inserPedido(@RequestBody @Valid PedidoDTO dto){
        dto = pedidoService.inserir(dto);
        return ResponseEntity.ok(dto);

    }

    @GetMapping ( value =  "/all")
    public ResponseEntity<List<PedidoDTO>> getAllPedidos(){
        return ResponseEntity.ok(pedidoService.getAll());
    }

    @GetMapping ( value = "/get/{id}")
    public ResponseEntity<PedidoDTO> getProdutoByID(@PathVariable Long id){
        Pedido pedido = pedidoService.getById(id);
        PedidoDTO pedidoDTO = new PedidoDTO(pedido);
        return  ResponseEntity.ok(pedidoDTO);

    }

    @PutMapping ( value = "/updt/{id}")
    public ResponseEntity<PedidoDTO> updtPedido(@RequestBody PedidoDTO dto, @PathVariable Long id){
        return  ResponseEntity.ok(pedidoService.updtPedido(dto, id));
    }

    @DeleteMapping ( value = "/dell/{id}")
    public  ResponseEntity<String>  dellPedido(@PathVariable Long id){
        boolean deleted = pedidoService.dellById(id);
        if(deleted){
            return ResponseEntity.ok().body("Pedido deletado com sucesso");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível deletar o Pedido");
        }
    }



}
