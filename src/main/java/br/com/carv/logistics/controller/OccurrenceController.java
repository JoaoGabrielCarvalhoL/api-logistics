package br.com.carv.logistics.controller;

import br.com.carv.logistics.model.dto.request.OccurrenceRequest;
import br.com.carv.logistics.model.dto.response.OccurrenceResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OccurrenceController {

    @PostMapping
    ResponseEntity<OccurrenceResponse> registry(@PathVariable("deliveryId") Long deliveryId, @Valid @RequestBody OccurrenceRequest occurrence);

    @GetMapping
    ResponseEntity<List<OccurrenceResponse>> findAllOccurrences(@PathVariable("deliveryId") Long deliveryId);
}
