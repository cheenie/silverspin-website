package silverspin.ordermicroservice.mapper;

import org.springframework.beans.BeanUtils;
import silverspin.ordermicroservice.dto.OrderDto;
import silverspin.ordermicroservice.entity.OrderEntity;

public final class OrderMapper {

    private OrderMapper() {
        // empty constructor
    }
    
    public static OrderDto buildDto(OrderEntity orderEntity) {
        if (orderEntity != null) {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(orderEntity, orderDto);
            return orderDto;
        }

        return null;
    }

    public static OrderEntity buildEntity(OrderDto orderDto) {
        if(orderDto != null) {
            OrderEntity orderEntity = new OrderEntity();
            BeanUtils.copyProperties(orderDto, orderEntity);
            return orderEntity;
        }

        return null;
    }
}
