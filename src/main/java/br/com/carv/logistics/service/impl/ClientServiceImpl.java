package br.com.carv.logistics.service.impl;

import br.com.carv.logistics.exception.ResourceNotFoundException;
import br.com.carv.logistics.exception.EmailUnavailableException;
import br.com.carv.logistics.model.Client;
import br.com.carv.logistics.model.dto.request.ClientRequest;
import br.com.carv.logistics.model.dto.response.ClientResponse;
import br.com.carv.logistics.repository.ClientRepository;
import br.com.carv.logistics.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final Logger logger = Logger.getLogger(ClientServiceImpl.class.getSimpleName());

    private final ModelMapper mapper;

    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.mapper = modelMapper;
    }

    @Override
    public ClientResponse findByIdResponse(Long id) {
        logger.info("Getting client by id: " + id);
        return clientRepository.findById(id)
                .map(client -> mapper.map(client, ClientResponse.class))
                .orElseThrow(() -> new ResourceNotFoundException("client.not.found"));
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting client by id: " + id);
        clientRepository.delete(findById(id));
    }

    @Override
    public Client findById(Long id) {
       return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("client.not.found"));
    }

    @Override
    public Page<ClientResponse> findAllPageable(Pageable pageable) {
        logger.info("Getting all clients paginated");
        List<ClientResponse> clients = clientRepository.findAll(pageable).stream()
                .map(client -> mapper.map(client, ClientResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<ClientResponse>(clients, pageable, clients.size());
    }

    @Override
    public List<ClientResponse> findAll() {
        logger.info("Getting all clients");
        return clientRepository.findAll().stream().map(client -> mapper.map(client, ClientResponse.class)).collect(Collectors.toList());
    }

    @Override
    public ClientResponse save(ClientRequest client) {
        logger.info("Saving client into database");
        Boolean usedEmail = clientRepository.findByEmail(client.getEmail())
                .stream().anyMatch(c -> !c.equals(client));
        if(usedEmail) {
            throw new EmailUnavailableException("email.unavailable");
        }
        Client entity = mapper.map(client, Client.class);
        clientRepository.save(entity);
        return mapper.map(entity, ClientResponse.class);
    }

    @Override
    public ClientResponse update(ClientRequest client) {
        logger.info("Update client into database");
        Client entity = mapper.map(client, Client.class);
        clientRepository.saveAndFlush(entity);
        return mapper.map(entity, ClientResponse.class);

    }

    @Override
    public List<ClientResponse> findByName(String name) {
        logger.info("Getting client by name: " + name);
        return clientRepository.findByName(name).stream().map(client -> mapper.map(client, ClientResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findByNameContaining(String name) {
        logger.info("Getting client containing name: " + name);
        return clientRepository.findByNameContaining(name).stream().map(client -> mapper.map(client, ClientResponse.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ClientResponse> findByEmail(String email) {
        logger.info("Searching email...");
        return clientRepository.findByEmail(email).stream().map(client -> mapper.map(client, ClientResponse.class)).findFirst();
    }
}
