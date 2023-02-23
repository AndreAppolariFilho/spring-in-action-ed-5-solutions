package chapter08.messagingSender.rabbitmq;

import chapter08.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
