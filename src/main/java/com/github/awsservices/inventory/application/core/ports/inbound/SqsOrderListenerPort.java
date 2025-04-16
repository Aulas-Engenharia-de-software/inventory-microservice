package com.github.awsservices.inventory.application.core.ports.inbound;

import com.github.awsservices.inventory.application.core.domain.OrderEvent;

public interface SqsOrderListenerPort {

    void listen(OrderEvent orderEvent);
}
