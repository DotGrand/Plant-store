package org.project.plantstore.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.plantstore.entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderInfoDAOImpl implements OrderInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<OrderInfo> getOrderList() {

        Session session = sessionFactory.getCurrentSession();

        Query<OrderInfo> query =
                session.createQuery("from OrderInfo order by dateOfOrder desc", OrderInfo.class);
        List<OrderInfo> orders = query.getResultList();

        return orders;
    }

    @Override
    public OrderInfo getOrder(Long id) {
        Session session = sessionFactory.getCurrentSession();

        OrderInfo orderInfo = session.get(OrderInfo.class, id);

        return orderInfo;
    }

    @Override
    public void saveOrder(OrderInfo orderInfo) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(orderInfo);
    }

    @Override
    public void deleteOrder(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from OrderInfo where orderId=:orderId");
        query.setParameter("orderId", id).executeUpdate();
    }

    @Override
    public List<OrderInfo> getOrderedPlants() {

        Session session = sessionFactory.getCurrentSession();

        Query<OrderInfo> query = session.createQuery("from OrderInfo where status='ORDERED'", OrderInfo.class);
        List<OrderInfo> plants = query.getResultList();

        return plants;

    }

    @Override
    public List<OrderInfo> getRejectedOrders() {
        Session session = sessionFactory.getCurrentSession();

        Query<OrderInfo> query =
                session.createQuery("from OrderInfo where status='REJECTED'", OrderInfo.class);
        List<OrderInfo> plants = query.getResultList();

        return plants;
    }

    @Override
    public List<OrderInfo> searchOrderByOrderId(Long orderId) {
        Session session = sessionFactory.getCurrentSession();

        Query<OrderInfo> query =
                session.createQuery("from OrderInfo where orderId=:orderId", OrderInfo.class);
        query.setParameter("orderId", orderId);

        List<OrderInfo> orders = query.getResultList();

        return orders;
    }

    @Override
    public List<OrderInfo> searchOrderByClientId(Long clientId) {
        Session session = sessionFactory.getCurrentSession();

        Query<OrderInfo> query =
                session.createQuery("from OrderInfo where client.id=:clientId", OrderInfo.class);
        query.setParameter("clientId", clientId);

        List<OrderInfo> orders = query.getResultList();

        return orders;
    }

    @Override
    public List<OrderInfo> searchOrderByPlantId(Long plantId) {
        Session session = sessionFactory.getCurrentSession();

        Query<OrderInfo> query =
                session.createQuery("from OrderInfo where plant.id=:plantId", OrderInfo.class);
        query.setParameter("plantId", plantId);

        List<OrderInfo> orders = query.getResultList();

        return orders;
    }
}
