package silverspin.shippingmicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import silverspin.shippingmicroservice.entity.ShippingEntity;
import java.util.Optional;

public interface ShippingRepository extends JpaRepository<ShippingEntity, Long> {
    public Optional<ShippingEntity> findByTrackingNumber(String trackingNumber);
}
