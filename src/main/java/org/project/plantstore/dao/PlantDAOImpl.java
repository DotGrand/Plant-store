package org.project.plantstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.plantstore.entity.Client;
import org.project.plantstore.entity.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantDAOImpl implements PlantDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Plant> getPlants() {
        Session session = sessionFactory.getCurrentSession();

        Query<Plant> query = session.createQuery("from Plant", Plant.class);
        List<Plant> plants = query.getResultList();

        return plants;
    }

    @Override
    public Plant getPlant(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Plant plant = session.get(Plant.class, id);

        return plant;
    }

    @Override
    public void savePlant(Plant plant) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(plant);
    }

    @Override
    public void deletePlant(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Plant where id=:plantId");
        query.setParameter("plantId", id).executeUpdate();
    }

    @Override
    public List<Plant> searchPlant(String searchPlant) {
        Session session = sessionFactory.getCurrentSession();

        Query<Plant> query =
                session.createQuery("from Plant where lower(name) like :theName or lower(price) like :theName" +
                        " or lower(quantity) like :theName", Plant.class);
        query.setParameter("theName", "%" + searchPlant.toLowerCase() + "%");

        List<Plant> foundPlants = query.getResultList();

        return foundPlants;
    }

    @Override
    public List<Client> getPlantClients(Long plantId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Plant p join fetch p.clients where p.id = :id");

        Plant plant = (Plant) query.setParameter("id", plantId).getSingleResult();
        List<Client> clients = plant.getClients();

        return clients;
    }
}
