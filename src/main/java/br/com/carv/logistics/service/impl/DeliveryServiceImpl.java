package br.com.carv.logistics.service.impl;

import br.com.carv.logistics.exception.BusinessException;
import br.com.carv.logistics.exception.ResourceNotFoundException;
import br.com.carv.logistics.model.Delivery;
import br.com.carv.logistics.model.dto.request.DeliveryRequest;
import br.com.carv.logistics.model.dto.response.DeliveryResponse;
import br.com.carv.logistics.model.enumeration.DeliveryStatus;
import br.com.carv.logistics.repository.DeliveryRepository;
import br.com.carv.logistics.service.ClientService;
import br.com.carv.logistics.service.DeliveryService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ClientService clientService;

    private final ModelMapper mapper;
    private Logger logger = Logger.getLogger(DeliveryServiceImpl.class.getSimpleName());

    public DeliveryServiceImpl (DeliveryRepository deliveryRepository, ClientService clientService, ModelMapper mapper) {
        this.deliveryRepository = deliveryRepository;
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @Override
    public Delivery findById(Long id) {
        logger.info("Getting delivery by id: " + id);
        return deliveryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("delivery.not.found"));
    }

    @Override
    public DeliveryResponse findByIdResponse(Long id) {
        logger.info("Getting delivery by id: " + id);
        return deliveryRepository.findById(id)
                        .map(delivery -> mapper.map(delivery, DeliveryResponse.class))
                .orElseThrow(() -> new ResourceNotFoundException("delivery.not.found"));
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting client by id: " + id);
        deliveryRepository.delete(findById(id));
    }

    @Override
    public Page<DeliveryResponse> findAllPageable(Pageable pageable) {
        logger.info("Getting all deliveries paginated");
        List<DeliveryResponse> deliveries = deliveryRepository.findAll(pageable).stream().map(delivery -> mapper.map(delivery, DeliveryResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<DeliveryResponse>(deliveries, pageable, deliveries.size());
    }

    @Override
    public List<DeliveryResponse> findAll() {
        logger.info("Getting all deliveries");
        return deliveryRepository.findAll().stream().map(delivery -> mapper.map(delivery, DeliveryResponse.class)).collect(Collectors.toList());
    }

    @Override
    public DeliveryResponse save(DeliveryRequest delivery, Long id) {
        logger.info("Saving delivery into database");
        Delivery entity = mapper.map(delivery, Delivery.class);
        entity.setDeliveryStatus(DeliveryStatus.PENDING);
        entity.setOrderDate(LocalDate.now());
        entity.setClient(clientService.findById(id));
        deliveryRepository.save(entity);
        return mapper.map(entity, DeliveryResponse.class);
    }

    @Override
    public DeliveryResponse update(DeliveryRequest delivery, Long id) {
        return save(delivery, id);
    }

    @Override
    @Transactional
    public void finalizeDelivery(Long id) {
        logger.info("Requesting completion of delivery.");
        Delivery delivery = findById(id);
        if (delivery.getDeliveryStatus() == DeliveryStatus.CANCELED) {
            throw new BusinessException("The delivery was cancelled.");
        } else if (delivery.getDeliveryStatus() == DeliveryStatus.FINISHED) {
            throw new BusinessException("Delivery has now been completed.");
        }
        delivery.setDeliveryStatus(DeliveryStatus.FINISHED);
        delivery.setCompletionDate(LocalDate.now());
    }
}
