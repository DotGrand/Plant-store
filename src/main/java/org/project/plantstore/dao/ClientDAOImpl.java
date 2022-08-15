package org.project.plantstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.project.plantstore.entity.Client;
import org.project.plantstore.entity.Plant;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Client> getClients() {
        Session session = sessionFactory.getCurrentSession();

        Query<Client> query = session.createQuery("from Client order by registrationDate desc", Client.class);
        List<Client> clients = query.getResultList();

        return clients;
    }

    @Override
    public Client getClient(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Client client = session.get(Client.class, id);

        return client;
    }

    @Override
    public void saveClient(Client client) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(client);
    }


    @Override
    public void deleteClient(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Query query =
                session.createQuery("delete from Client where id=:clientId");
        session.createQuery("update OrderInfo set client.id=null").executeUpdate();

        query.setParameter("clientId", id).executeUpdate();
    }

    @Override
    public List<Client> searchClients(String searchName) {
        Session session = sessionFactory.getCurrentSession();

        Query<Client> query = session.createQuery("from Client where lower(firstName) like :theName" +
                " or lower(lastName) like :theName", Client.class);
        query.setParameter("theName", "%" + searchName.toLowerCase() + "%");

        List<Client> clients = query.getResultList();

        return clients;

    }

    @Override
    public List<Plant> getClientPlants(Long clientId) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from Client c join fetch c.plants WHERE c.id = :id");

        Client client = (Client) q.setParameter("id", clientId).getSingleResult();
        List<Plant> plants = client.getPlants();

        return plants;
    }
}
