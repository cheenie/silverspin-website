package silverspin.shippingmicroservice.service;

import java.time.LocalDateTime;
import silverspin.shippingmicroservice.dto.ShippingDto;
import silverspin.shippingmicroservice.entity.ShippingEntity;
import silverspin.shippingmicroservice.mapper.ShippingMapper;
import silverspin.shippingmicroservice.enums.ShippingStatus;
import silverspin.shippingmicroservice.repo.ShippingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.security.SecureRandom;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }
    
    public List<ShippingDto> getAllShipments() {
        return shippingRepository.findAll().stream()
                .map(ShippingMapper::buildDto)
                .toList();
    }

    public ShippingDto getShipmentByTrackingNumber(String trackingNumber) throws Exception {
        ShippingEntity shippingEntity = shippingRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new Exception("Shipment not found with tracking number: " + trackingNumber));
        return ShippingMapper.buildDto(shippingEntity);
    }

    public ShippingDto createShipment(ShippingDto shippingDto) {
        ShippingEntity shippingEntity = ShippingMapper.buildEntity(shippingDto);
        shippingEntity.setShippingStatus(ShippingStatus.TO_SHIP);
        shippingEntity.setTrackingNumber(generateTrackingNumber());

        ShippingEntity savedShippingEntity = shippingRepository.save(shippingEntity);
        return ShippingMapper.buildDto(savedShippingEntity);
    }

    public ShippingDto updateShipmentStatus(String trackingNumber, ShippingStatus shippingStatus) throws Exception {
        ShippingEntity shippingEntity = shippingRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new Exception("Shipment not found with tracking number: " + trackingNumber));
        shippingEntity.setShippingStatus(shippingStatus);
        shippingEntity.setShippingDate(LocalDateTime.now());

        ShippingEntity savedShippingEntity = shippingRepository.save(shippingEntity);
        return ShippingMapper.buildDto(savedShippingEntity);
    }

    private String generateTrackingNumber() {
        SecureRandom secureRandom = new SecureRandom();
        return "SS-" + System.currentTimeMillis() + "-" + secureRandom.nextInt(1000000);
    }
}
