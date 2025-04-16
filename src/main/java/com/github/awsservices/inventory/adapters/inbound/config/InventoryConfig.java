package com.github.awsservices.inventory.adapters.inbound.config;

import com.github.awsservices.inventory.application.core.ports.inbound.OrderEventHandlerPort;
import com.github.awsservices.inventory.application.core.services.InventoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryConfig {

    @Bean
    public OrderEventHandlerPort orderEventHandlerPort() {
        return new InventoryService();
    }
}
