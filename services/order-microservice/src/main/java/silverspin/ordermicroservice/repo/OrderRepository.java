package silverspin.ordermicroservice.repo;

import silverspin.ordermicroservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
