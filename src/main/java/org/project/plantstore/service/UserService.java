package org.project.plantstore.service;

import org.project.plantstore.entity.User;
import org.project.plantstore.user.PlantStorageUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(PlantStorageUser user);
}
