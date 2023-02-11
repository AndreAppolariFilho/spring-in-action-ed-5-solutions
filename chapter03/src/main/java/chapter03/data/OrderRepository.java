package chapter03.data;

import chapter03.Order;

public interface OrderRepository {
    Order save(Order order);
}
