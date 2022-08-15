package org.project.plantstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.plantstore.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellerDAOImpl implements SellerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Seller> getSellers() {
        Session session = sessionFactory.getCurrentSession();

        Query<Seller> query = session.createQuery("from Seller", Seller.class);
        List<Seller> sellers = query.getResultList();

        return sellers;
    }

    @Override
    public void saveSeller(Seller seller) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(seller);
    }

    @Override
    public Seller getSeller(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Seller seller = session.get(Seller.class, id);

        return seller;
    }

    @Override
    public void deleteSeller(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Seller where id=:sellerId");
        query.setParameter("sellerId", id).executeUpdate();
    }

    @Override
    public List<Seller> searchSeller(String searchSeller) {
        Session session = sessionFactory.getCurrentSession();

        Query<Seller> query =
                session.createQuery("from Seller where lower(firstName) like :theName" +
                        " or lower(lastName) like :theName", Seller.class);
        query.setParameter("theName", "%" + searchSeller.toLowerCase() + "%");

        List<Seller> foundSellers = query.getResultList();

        return foundSellers;
    }
}
