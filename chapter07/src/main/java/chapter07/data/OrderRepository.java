package chapter07.data;

import chapter07.Order;
import chapter07.User;
import org.springframework.data.repository.CrudRepository;


import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
