package chapter08.kitchen.messaging.jms;

import chapter08.Order;
import chapter08.kitchen.OrderReceiver;
import org.springframework.jms.core.JmsTemplate;

public class JmsOrderReceiver implements OrderReceiver {
    private JmsTemplate jms;

    public JmsOrderReceiver(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public Order receiveOrder() {
        return (Order) jms.receiveAndConvert("tacocloud.order.queue");
    }
}
