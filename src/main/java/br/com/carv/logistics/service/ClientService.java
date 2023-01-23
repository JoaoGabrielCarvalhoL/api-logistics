package br.com.carv.logistics.service;

import br.com.carv.logistics.model.Client;
import br.com.carv.logistics.model.dto.request.ClientRequest;
import br.com.carv.logistics.model.dto.response.ClientResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientResponse findByIdResponse(final Long id);

    Client findById(final Long id);

    void delete(final Long id);

    Page<ClientResponse> findAllPageable(Pageable pageable);

    List<ClientResponse> findAll();

    ClientResponse save(ClientRequest client);

    ClientResponse update(ClientRequest client);

    List<ClientResponse> findByName(String  name);
    List<ClientResponse> findByNameContaining(String name);

    Optional<ClientResponse> findByEmail(String email);
}
