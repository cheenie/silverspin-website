package silverspin.ordermicroservice.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import silverspin.ordermicroservice.entity.OrderEntity;
import silverspin.ordermicroservice.enums.OrderStatus;
import silverspin.ordermicroservice.mapper.OrderMapper;
import silverspin.ordermicroservice.repo.OrderRepository;
import silverspin.ordermicroservice.dto.OrderDto;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return orderEntities.stream()
                .map(OrderMapper::buildDto)
                .toList();
    }

    public OrderDto getOrderById(Long id) throws Exception {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new Exception("Order not found with id: " + id));
        return OrderMapper.buildDto(orderEntity);
    }

    public OrderDto createOrder(OrderDto orderDto) {
        OrderEntity orderEntity = OrderMapper.buildEntity(orderDto);
        orderEntity.setOrderStatus(OrderStatus.NEW);
        orderEntity.setOrderTimestamp(LocalDateTime.now());

        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        return OrderMapper.buildDto(savedOrderEntity);
    }

    public OrderDto cancelOrder(Long id) throws Exception {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new Exception("Order not found with id: " + id));
        orderEntity.setOrderStatus(OrderStatus.CANCELLED);
        
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        return OrderMapper.buildDto(savedOrderEntity);
    }
}
