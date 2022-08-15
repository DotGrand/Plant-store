package org.project.plantstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.plantstore.entity.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class DescriptionDAOImpl implements DescriptionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Description> getDescriptions() {
        Session session = sessionFactory.getCurrentSession();

        Query<Description> query = session.createQuery("from Description ", Description.class);
        List<Description> descriptions = query.getResultList();

        return descriptions;
    }

    @Override
    public void saveDescription(Description description) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(description);
    }

    @Override
    public Description getDescription(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Description description = session.get(Description.class, id);

        return description;
    }

    @Override
    public void deleteDescription(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Description where id= :descriptionId");
        query.setParameter("descriptionId", id).executeUpdate();
    }
}
