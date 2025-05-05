package com.revisao.ecommerce.repositories;

import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.entities.ItemDoPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido,
        ItemDoPedidoPK> {
}
