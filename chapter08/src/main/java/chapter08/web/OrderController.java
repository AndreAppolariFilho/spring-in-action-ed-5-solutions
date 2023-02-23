package chapter08.web;

import chapter08.Order;
import chapter08.User;
import chapter08.data.OrderRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
    private OrderRepository orderRepo;
    private OrderProps props;
    public OrderController(OrderRepository orderRepository){
        orderRepo = orderRepository;
    }
    @GetMapping("/current")
    public String orderForm(Model model){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid Order order,
            Errors errors,
            SessionStatus sessionStatus,
            @AuthenticationPrincipal User user
    ){
        if(errors.hasErrors()){
            return "orderForm";
        }
        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(
            @AuthenticationPrincipal User user, Model model) {

        Pageable pageable = PageRequest.of(0, props.getPageSize());
        model.addAttribute("orders",
                orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));

        return "orderList";
    }
}
