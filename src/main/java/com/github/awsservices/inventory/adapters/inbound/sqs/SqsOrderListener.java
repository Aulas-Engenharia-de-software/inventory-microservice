package com.github.awsservices.inventory.adapters.inbound.sqs;

import com.github.awsservices.inventory.application.core.domain.Order;
import com.github.awsservices.inventory.application.core.ports.inbound.OrderEventHandlerPort;
import com.github.awsservices.inventory.application.core.ports.inbound.SqsOrderListenerPort;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SqsOrderListener implements SqsOrderListenerPort {

    private final Logger logger = LoggerFactory.getLogger(SqsOrderListener.class);

    private final OrderEventHandlerPort orderEventHandlerPort;

    public SqsOrderListener(OrderEventHandlerPort orderEventHandlerPort) {
        this.orderEventHandlerPort = orderEventHandlerPort;
    }

    @Override
    @SqsListener(value = "${aws.sqs.queue-name}")
    public void listen(Order order) {
        logger.info("iniciando consumo do evento recebido da fila: {}", order);

        orderEventHandlerPort.handleOrderEvent(order);
    }
}
