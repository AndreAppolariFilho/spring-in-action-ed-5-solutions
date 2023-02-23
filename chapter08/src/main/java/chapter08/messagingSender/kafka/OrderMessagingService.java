package chapter08.messagingSender.kafka;

import chapter08.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);
}
