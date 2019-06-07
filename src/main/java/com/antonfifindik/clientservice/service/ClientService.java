package com.antonfifindik.clientservice.service;

import com.antonfifindik.clientservice.model.db.Client;
import com.antonfifindik.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client getOne(UUID id) {
        return  clientRepository.getOne(id);
    }

    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public void deleteAll(List<Client> clients) {
        clientRepository.deleteAll(clients);
    }

    public void saveAndFlush(Client client) {
        clientRepository.saveAndFlush(client);
    }

    public void saveAll(List<Client> clients) {
        clientRepository.saveAll(clients);
    }

    public Long count() {
        return clientRepository.count();
    }

    public boolean existById(UUID id) {
        return clientRepository.existsById(id);
    }

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
