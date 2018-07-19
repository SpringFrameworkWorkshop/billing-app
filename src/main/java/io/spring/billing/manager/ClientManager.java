package io.spring.billing.manager;

import io.spring.billing.entities.Client;
import io.spring.billing.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientManager extends AbstractManager<Client> {

    private ClientRepository repository;

    @Autowired
    public ClientManager(final ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClientRepository getRepository() {
        return this.repository;
    }

    public Page<Client> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public List<Client> findByNameAndSurnameAllIgnoreCase(final String name, final String surname) {
        return this.repository.findByNameAndSurnameAllIgnoreCase(name,surname);
    }

    public List<Client> findBySurnameOrderByNameDesc(String surname) {
        return this.repository.findBySurnameOrderByNameDesc(surname);
    }

    public Client fetchByIdWithBills(Long id) {
        return this.repository.fetchByIdWithBills(id);
    }


}
