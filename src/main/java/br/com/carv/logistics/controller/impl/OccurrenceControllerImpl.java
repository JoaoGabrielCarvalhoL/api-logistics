package br.com.carv.logistics.controller.impl;

import br.com.carv.logistics.controller.OccurrenceController;
import br.com.carv.logistics.model.dto.request.OccurrenceRequest;
import br.com.carv.logistics.model.dto.response.OccurrenceResponse;
import br.com.carv.logistics.service.OccurrenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceControllerImpl implements OccurrenceController {

    private final OccurrenceService occurrenceService;

    public OccurrenceControllerImpl(OccurrenceService occurrenceService) {
        this.occurrenceService = occurrenceService;
    }

    @Override
    public ResponseEntity<OccurrenceResponse> registry(Long deliveryId, OccurrenceRequest occurrence) {
        return ResponseEntity.status(HttpStatus.CREATED).body(occurrenceService.registry(deliveryId, occurrence));
    }

    @Override
    public ResponseEntity<List<OccurrenceResponse>> findAllOccurrences(Long deliveryId) {
        return ResponseEntity.status(HttpStatus.OK).body(occurrenceService.findAllOccurrences(deliveryId));
    }
}
