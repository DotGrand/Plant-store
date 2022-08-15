package org.project.plantstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.project.plantstore.dao.ClientDAO;
import org.project.plantstore.entity.Client;
import org.project.plantstore.entity.Plant;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public List<Client> getClients() {
        return clientDAO.getClients();
    }

    @Override
    public Client getClient(Long id) {
        return clientDAO.getClient(id);
    }

    @Override
    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientDAO.deleteClient(id);
    }

    @Override
    public List<Client> searchClients(String searchName) {
        return clientDAO.searchClients(searchName);
    }

    @Override
    public List<Plant> getClientPlants(Long clientId) {
        return clientDAO.getClientPlants(clientId);
    }
}
