package silverspin.ordermicroservice.dto;

import java.util.Set;
import java.time.LocalDateTime;
import silverspin.ordermicroservice.enums.OrderStatus;

public class OrderDto {

    private Long id;
    private LocalDateTime orderTimestamp;
    private OrderStatus orderStatus;
    private Set<ItemDto> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(LocalDateTime orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<ItemDto> getItems() {
        return items;
    }

    public void setItems(Set<ItemDto> items) {
        this.items = items;
    }

}
