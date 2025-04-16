package com.github.awsservices.inventory.adapters.inbound.sqs;

import com.github.awsservices.inventory.application.core.domain.OrderEvent;
import com.github.awsservices.inventory.application.core.ports.inbound.OrderEventHandlerPort;
import com.github.awsservices.inventory.application.core.ports.inbound.SqsOrderListenerPort;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsOrderListener implements SqsOrderListenerPort {

    private final OrderEventHandlerPort orderEventHandlerPort;

    public SqsOrderListener(OrderEventHandlerPort orderEventHandlerPort) {
        this.orderEventHandlerPort = orderEventHandlerPort;
    }

    @Override
    @SqsListener("${sqs.queue.inventory}")
    public void listen(OrderEvent orderEvent) {
        orderEventHandlerPort.handleOrderEvent(orderEvent);
    }
}
