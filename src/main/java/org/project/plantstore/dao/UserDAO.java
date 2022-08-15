package org.project.plantstore.dao;

import org.project.plantstore.entity.User;

public interface UserDAO {

    User findByUserName(String userName);

    void save(User user);
}
