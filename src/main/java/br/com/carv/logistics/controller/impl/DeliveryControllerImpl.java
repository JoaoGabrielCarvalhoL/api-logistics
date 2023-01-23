package br.com.carv.logistics.controller.impl;

import br.com.carv.logistics.controller.DeliveryController;
import br.com.carv.logistics.model.Delivery;
import br.com.carv.logistics.model.dto.request.DeliveryRequest;
import br.com.carv.logistics.model.dto.response.DeliveryResponse;
import br.com.carv.logistics.service.DeliveryService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("deliveries")
@RestController
public class DeliveryControllerImpl implements DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryControllerImpl(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }
    @Override
    public ResponseEntity<DeliveryResponse> save(DeliveryRequest delivery, Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryService.save(delivery, id));
    }

    @Override
    public ResponseEntity<DeliveryResponse> update(DeliveryRequest delivery, Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deliveryService.update(delivery, id));
    }

    @Override
    public ResponseEntity<DeliveryResponse> findById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryService.findByIdResponse(id));
    }

    @Override
    public ResponseEntity<Page<DeliveryResponse>> findAllPaginated(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryService.findAllPageable(pageable));
    }

    @Override
    public ResponseEntity<List<DeliveryResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryService.findAll());
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        deliveryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Void> finalize(Long id) {
        deliveryService.finalizeDelivery(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
