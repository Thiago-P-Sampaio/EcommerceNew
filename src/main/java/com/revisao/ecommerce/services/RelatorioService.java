package com.revisao.ecommerce.services;

import com.revisao.ecommerce.dto.RelatorioPedidoDTO;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.repositories.PedidoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    @Autowired
    PedidoRepository pedidoRepository;


    public void gerarRelatorioPDF(String caminho) throws JRException {
        List<Pedido> pedidos = pedidoRepository.findAll();

        List<RelatorioPedidoDTO> dados = pedidos.stream()
                .map(RelatorioPedidoDTO :: new)
                .collect(Collectors.toList());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dados);
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("titulo", " Relatório de Pedidos ");

        JasperReport jasperReport = JasperCompileManager.compileReport(
                getClass().getResourceAsStream("/relatorios/relatorio_pedidos.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, caminho);



    }
}
