package org.project.plantstore.service;

import org.project.plantstore.dao.PlantDAO;
import org.project.plantstore.entity.Client;
import org.project.plantstore.entity.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantDAO plantDAO;

    @Override
    public List<Plant> getPlants() {
        return plantDAO.getPlants();
    }

    @Override
    public Plant getPlant(Long id) {
        return plantDAO.getPlant(id);
    }

    @Override
    public void savePlant(Plant plant) {
        plantDAO.savePlant(plant);
    }

    @Override
    public void deletePlant(Long id) {
        plantDAO.deletePlant(id);
    }

    @Override
    public List<Plant> searchPlant(String searchPlant) {
        return plantDAO.searchPlant(searchPlant);
    }

    @Override
    public List<Client> getPlantClients(Long plantId) {
        return plantDAO.getPlantClients(plantId);
    }
}
