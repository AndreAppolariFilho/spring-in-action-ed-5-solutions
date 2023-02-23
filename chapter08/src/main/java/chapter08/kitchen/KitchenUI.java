package chapter08.kitchen;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import chapter08.Order;

@Component
@Slf4j
public class KitchenUI {

    public void displayOrder(Order order) {

        log.info("RECEIVED ORDER:  " + order);
    }

}
