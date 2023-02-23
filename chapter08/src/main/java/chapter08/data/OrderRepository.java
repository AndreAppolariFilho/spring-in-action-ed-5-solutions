package chapter08.data;

import chapter08.Order;
import chapter08.User;
import org.springframework.data.repository.CrudRepository;


import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
