package br.com.carv.logistics.service;

import br.com.carv.logistics.model.Occurrence;
import br.com.carv.logistics.model.dto.request.OccurrenceRequest;
import br.com.carv.logistics.model.dto.response.OccurrenceResponse;

import java.util.List;

public interface OccurrenceService {

    OccurrenceResponse registry(Long deliveryId, OccurrenceRequest occurrence);

    List<OccurrenceResponse> findAllOccurrences(final Long deliveryId);
}
