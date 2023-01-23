package br.com.carv.logistics.repository;

import br.com.carv.logistics.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
