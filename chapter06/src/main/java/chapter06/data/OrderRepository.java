package chapter06.data;

import chapter06.Order;
import chapter06.User;
import org.springframework.data.repository.CrudRepository;


import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
