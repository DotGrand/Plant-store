package org.project.plantstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.plantstore.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findRoleByName(String theRoleName) {
        Role theRole;
        Session session = sessionFactory.getCurrentSession();

        Query<Role> theQuery = session.createQuery("from Role where name=:roleName");
        theQuery.setParameter("roleName", theRoleName);

        try {
            theRole = theQuery.getSingleResult();
        } catch (Exception exc) {
            theRole = null;
        }

        return theRole;
    }
}
