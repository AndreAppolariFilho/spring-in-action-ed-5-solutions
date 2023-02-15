package chapter05.data;

import chapter05.Order;
import chapter05.User;
import org.springframework.data.repository.CrudRepository;


import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
