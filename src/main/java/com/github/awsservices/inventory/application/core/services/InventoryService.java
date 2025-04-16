package com.github.awsservices.inventory.application.core.services;

import com.github.awsservices.inventory.application.core.domain.OrderEvent;
import com.github.awsservices.inventory.application.core.ports.inbound.OrderEventHandlerPort;

public class InventoryService implements OrderEventHandlerPort {
    @Override
    public void handleOrderEvent(OrderEvent event) {
        System.out.println("[Inventory] Atualizando estoque para pedido: " + event.getOrderId());
    }
}
