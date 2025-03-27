package silverspin.shippingmicroservice.api;

import org.springframework.web.bind.annotation.*;
import silverspin.shippingmicroservice.dto.ShippingDto;
import silverspin.shippingmicroservice.enums.ShippingStatus;
import silverspin.shippingmicroservice.service.ShippingService;
import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingRestApi {

    private final ShippingService shippingService;
    
    public ShippingRestApi(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/all")
    public List<ShippingDto> getAllShipments() {
        return shippingService.getAllShipments();
    }

    @GetMapping("/{trackingNumber}")
    public ShippingDto getShipmentByTrackingNumber(@PathVariable String trackingNumber) throws Exception {
        return shippingService.getShipmentByTrackingNumber(trackingNumber);
    }

    @PostMapping()
    public ShippingDto createShipment(@RequestBody ShippingDto shippingDto) {
        return shippingService.createShipment(shippingDto);
    }
    
    @PatchMapping("/{trackingNumber}")
    public ShippingDto updateShipmentStatus(@PathVariable String trackingNumber, @RequestBody ShippingDto shippingDto) throws Exception {
        return shippingService.updateShipmentStatus(trackingNumber, shippingDto.getShippingStatus());
    }

}
