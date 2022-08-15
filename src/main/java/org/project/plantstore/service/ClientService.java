package org.project.plantstore.service;

import org.project.plantstore.entity.Client;
import org.project.plantstore.entity.Plant;

import java.util.List;

public interface ClientService {

    List<Client> getClients();

    Client getClient(Long id);

    void saveClient(Client client);

    void deleteClient(Long id);

    List<Client> searchClients(String searchName);

    List<Plant> getClientPlants(Long clientId);
}
