package silverspin.shippingmicroservice.mapper;

import org.springframework.beans.BeanUtils;
import silverspin.shippingmicroservice.dto.ShippingDto;
import silverspin.shippingmicroservice.entity.ShippingEntity;

public final class ShippingMapper {

    private ShippingMapper(){
        // empty constructor
    }

    public static ShippingDto buildDto(ShippingEntity shippingEntity) {
        if (shippingEntity != null) {
            ShippingDto shippingDto = new ShippingDto();
            BeanUtils.copyProperties(shippingEntity, shippingDto);
            return shippingDto;
        }

        return null;
    }

    public static ShippingEntity buildEntity(ShippingDto shippingDto) {
        if(shippingDto != null) {
            ShippingEntity shippingEntity = new ShippingEntity();
            BeanUtils.copyProperties(shippingDto, shippingEntity);
            return shippingEntity;
        }

        return null;
    }

}
