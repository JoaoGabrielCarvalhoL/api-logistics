package br.com.carv.logistics.repository;

import java.util.List;
import java.util.Optional;

import br.com.carv.logistics.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByName(String name);
    List<Client> findByNameContaining(String name);
    Optional<Client> findByEmail(String email);
}
