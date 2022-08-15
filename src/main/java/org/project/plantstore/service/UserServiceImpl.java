package org.project.plantstore.service;

import org.project.plantstore.dao.RoleDAO;
import org.project.plantstore.dao.UserDAO;
import org.project.plantstore.entity.Role;
import org.project.plantstore.entity.User;
import org.project.plantstore.user.PlantStorageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    @Override
    public void save(PlantStorageUser plantStorageUser) {
        User user = new User();

        user.setUserName(plantStorageUser.getUserName());
        user.setPassword(passwordEncoder.encode(plantStorageUser.getPassword()));
        user.setFirsName(plantStorageUser.getFirstName());
        user.setLastName(plantStorageUser.getLastName());
        user.setEmail(plantStorageUser.getEmail());

        user.setRoles(Collections.singletonList(roleDAO.findRoleByName("ROLE_SELLER")));

        userDAO.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username of password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
