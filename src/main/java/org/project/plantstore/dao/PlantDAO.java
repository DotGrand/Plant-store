package org.project.plantstore.dao;

import org.project.plantstore.entity.Client;
import org.project.plantstore.entity.Plant;

import java.util.List;

public interface PlantDAO {

    List<Plant> getPlants();

    Plant getPlant(Long id);

    void savePlant(Plant plant);

    void deletePlant(Long id);

    List<Plant> searchPlant(String searchPlant);

    List<Client> getPlantClients(Long plantId);
}
