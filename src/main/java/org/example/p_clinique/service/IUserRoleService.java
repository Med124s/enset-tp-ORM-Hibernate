package org.example.p_clinique.service;

import org.example.p_clinique.entities.Role;
import org.example.p_clinique.entities.User;

import java.util.List;

public interface IUserRoleService {
    User AddUser(User user);
    User getUser(String username);
    List<User>users();
    Role AddRole(Role role);

    void AddRoleToUser(String username, String rolename);


    Role getRole(String rolename);

    User autentication(String username, String password);
}
