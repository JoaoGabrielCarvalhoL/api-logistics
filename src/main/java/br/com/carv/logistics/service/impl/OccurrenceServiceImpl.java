package br.com.carv.logistics.service.impl;

import br.com.carv.logistics.model.Occurrence;
import br.com.carv.logistics.model.dto.request.OccurrenceRequest;
import br.com.carv.logistics.model.dto.response.OccurrenceResponse;
import br.com.carv.logistics.repository.DeliveryRepository;
import br.com.carv.logistics.service.DeliveryService;
import br.com.carv.logistics.service.OccurrenceService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class OccurrenceServiceImpl implements OccurrenceService {

    private final DeliveryService deliveryService;
    private final DeliveryRepository deliveryRepository;
    private final ModelMapper mapper;

    private final Logger logger = Logger.getLogger(OccurrenceServiceImpl.class.getSimpleName());

    public OccurrenceServiceImpl(DeliveryService deliveryService, ModelMapper mapper, DeliveryRepository deliveryRepository) {
        this.deliveryService = deliveryService;
        this.mapper = mapper;
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    @Override
    public OccurrenceResponse registry(Long deliveryId, OccurrenceRequest occurrenceRequest) {
        Occurrence occurrence = deliveryService.findById(deliveryId)
                .addOccurrence(occurrenceRequest.getDescription());
        logger.info("Saving occurrence into database");
        return mapper.map(occurrence, OccurrenceResponse.class);
    }

    @Override
    public List<OccurrenceResponse> findAllOccurrences(Long deliveryId) {
        return toOccurrenceResponse(deliveryService.findById(deliveryId).getOccurrences());
    }

    private List<OccurrenceResponse> toOccurrenceResponse(List<Occurrence> occurrences) {
        return occurrences.stream().map(occurrence -> mapper.map(occurrence, OccurrenceResponse.class))
                .collect(Collectors.toList());
    }
}
