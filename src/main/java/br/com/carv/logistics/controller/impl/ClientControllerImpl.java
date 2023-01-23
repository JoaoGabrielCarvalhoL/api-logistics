package br.com.carv.logistics.controller.impl;

import br.com.carv.logistics.controller.ClientController;
import br.com.carv.logistics.model.Client;
import br.com.carv.logistics.model.dto.request.ClientRequest;
import br.com.carv.logistics.model.dto.response.ClientResponse;
import br.com.carv.logistics.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("clients")
@RestController
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<ClientResponse> save(ClientRequest client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }

    @Override
    public ResponseEntity<ClientResponse> update(ClientRequest client) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(client));
    }

    @Override
    public ResponseEntity<ClientResponse> findById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByIdResponse(id));
    }

    @Override
    public ResponseEntity<Page<ClientResponse>> findAllPaginated(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAllPageable(pageable));
    }

    @Override
    public ResponseEntity<List<ClientResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }

    @Override
    public ResponseEntity<List<ClientResponse>> findByName(String param) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByName(param));
    }

    @Override
    public ResponseEntity<List<ClientResponse>> findByNameContaining(String param) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByNameContaining(param));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
