package br.com.carv.logistics.controller;

import br.com.carv.logistics.model.Delivery;
import br.com.carv.logistics.model.dto.request.DeliveryRequest;
import br.com.carv.logistics.model.dto.response.DeliveryResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DeliveryController {

    @PostMapping("/{id}")
    ResponseEntity<DeliveryResponse> save(@Valid @RequestBody final DeliveryRequest delivery, @PathVariable("id") Long id);

    @PutMapping("/{id}")
    ResponseEntity<DeliveryResponse> update(@Valid @RequestBody final DeliveryRequest delivery, @PathVariable("id") Long id);

    @GetMapping("/{id}")
    ResponseEntity<DeliveryResponse> findById(@PathVariable("id") final Long id);

    @GetMapping("/paginated")
    ResponseEntity<Page<DeliveryResponse>> findAllPaginated(Pageable pageable);

    @GetMapping
    ResponseEntity<List<DeliveryResponse>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id);

    @PutMapping("/finalize/{id}")
    ResponseEntity<Void> finalize(@PathVariable("id") Long id);
}
