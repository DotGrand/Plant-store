package org.project.plantstore.dao;

import org.project.plantstore.entity.Role;

public interface RoleDAO {

    Role findRoleByName(String theRoleName);
}
