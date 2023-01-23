package br.com.carv.logistics.service;

import br.com.carv.logistics.model.Client;
import br.com.carv.logistics.model.Delivery;
import br.com.carv.logistics.model.dto.request.DeliveryRequest;
import br.com.carv.logistics.model.dto.response.DeliveryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {

    DeliveryResponse findByIdResponse(final Long id);

    Delivery findById(final Long id);

    void delete(final Long id);

    Page<DeliveryResponse> findAllPageable(Pageable pageable);

    List<DeliveryResponse> findAll();

    DeliveryResponse save(DeliveryRequest delivery, Long id);

    DeliveryResponse update(DeliveryRequest delivery, Long id);

    void finalizeDelivery(final Long id);

}
