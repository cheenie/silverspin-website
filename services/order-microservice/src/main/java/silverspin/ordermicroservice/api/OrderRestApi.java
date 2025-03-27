package silverspin.ordermicroservice.api;

import org.springframework.web.bind.annotation.*;
import silverspin.ordermicroservice.dto.OrderDto;
import silverspin.ordermicroservice.service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestApi {

    private final OrderService orderService;

    public OrderRestApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable("id") Long id) throws Exception {
        return orderService.getOrderById(id);
    }

    @PostMapping()
    public OrderDto createOrder(OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @PatchMapping("/{id}/cancel")
    public OrderDto cancelOrder(@PathVariable("id") Long id) throws Exception {
       return orderService.cancelOrder(id);
    }
}
