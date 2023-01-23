package br.com.carv.logistics.controller;

import br.com.carv.logistics.model.Client;
import br.com.carv.logistics.model.dto.request.ClientRequest;
import br.com.carv.logistics.model.dto.response.ClientResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientController {

    @PostMapping
    ResponseEntity<ClientResponse> save(@Valid @RequestBody final ClientRequest client);

    @PutMapping
    ResponseEntity<ClientResponse> update(@Valid @RequestBody final ClientRequest client);

    @GetMapping("/{id}")
    ResponseEntity<ClientResponse> findById(@PathVariable("id") final Long id);

    @GetMapping("/paginated")
    ResponseEntity<Page<ClientResponse>> findAllPaginated(Pageable pageable);

    @GetMapping
    ResponseEntity<List<ClientResponse>> findAll();

    @GetMapping("/query/{param}")
    ResponseEntity<List<ClientResponse>> findByName(@RequestParam("param") String param);

    @GetMapping("/query-containing/{param}")
    ResponseEntity<List<ClientResponse>> findByNameContaining(@RequestParam("param") String param);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id);
}
