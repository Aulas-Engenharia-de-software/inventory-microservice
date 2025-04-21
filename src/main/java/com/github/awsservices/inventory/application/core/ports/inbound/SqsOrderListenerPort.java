package com.github.awsservices.inventory.application.core.ports.inbound;

import com.github.awsservices.inventory.application.core.domain.Order;

public interface SqsOrderListenerPort {

    void listen(Order order);
}
