package com.github.awsservices.inventory.application.core.services;

import com.github.awsservices.inventory.application.core.domain.Order;
import com.github.awsservices.inventory.application.core.ports.inbound.OrderEventHandlerPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryService implements OrderEventHandlerPort {

    private final Logger logger = LoggerFactory.getLogger(InventoryService.class);

    @Override
    public void handleOrderEvent(Order order) {
        logger.info("[Inventory] Atualizando estoque para pedido: {}", order);
    }
}
