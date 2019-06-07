package com.antonfifindik.clientservice.controller;

import com.antonfifindik.clientservice.model.db.Client;
import com.antonfifindik.clientservice.service.ClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    @ApiOperation(notes = "Получить всех клиентов", value = "Get all clients")
    @GetMapping(value = "/")
    public List<Client> getAllClientList() {
        return clientService.findAll();
    }

    @ApiOperation(notes = "Получить клиента по идентификатору", value = "Get client by id")
    @GetMapping(value = "/{clientId}")
    public Client getClient(@PathVariable UUID clientId) {
        return clientService.getOne(clientId);
    }

    @ApiOperation(notes = "Удалить клиента по идентификатору", value = "Delete client by id")
    @DeleteMapping(value = "/{clientId}")
    public void deleteClientById(@PathVariable UUID clientId) {
        clientService.deleteById(clientId);
    }

    @ApiOperation(notes = "Удалить клиента", value = "Delete client")
    @DeleteMapping(value = "/client")
    public void deleteClient(@RequestBody Client client) {
        clientService.delete(client);
    }

    @ApiOperation(notes = "Удалить клиентов", value = "Delete clients (list)")
    @DeleteMapping(value = "/")
    public void deleteAll(@RequestBody List<Client> clients) {
        clientService.deleteAll(clients);
    }

    @ApiOperation(notes = "Сохранить клиента", value = "Save client")
    @PostMapping(value = "/client")
    public void saveClient(@RequestBody Client client) {
        clientService.saveAndFlush(client);
    }

    @ApiOperation(notes = "Сохранить клиентов", value = "Save clients (list)")
    @PostMapping(value = "/")
    public void saveAll(@RequestBody List<Client> clients) {
        clientService.saveAll(clients);
    }

    @ApiOperation(notes = "Получить количество клиентов", value = "Get count of clients")
    @GetMapping(value = "/count")
    public Long count() {
        return clientService.count();
    }

    @ApiOperation(notes = "Существует ли клиент?", value = "Is client exist?")
    @GetMapping(value = "/exist/{clientId}")
    public boolean existById(@PathVariable UUID clientId) {
        return clientService.existById(clientId);
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
