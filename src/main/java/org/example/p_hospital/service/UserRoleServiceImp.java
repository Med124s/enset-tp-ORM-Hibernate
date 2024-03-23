package org.example.p_hospital.service;

import jakarta.transaction.Transactional;
import org.example.p_hospital.entities.Role;
import org.example.p_hospital.entities.User;
import org.example.p_hospital.repository.RoleRepository;
import org.example.p_hospital.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
public class UserRoleServiceImp implements IUserRoleService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserRoleServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User AddUser(User user) {
        if (user == null){
            throw new RuntimeException("User is Null");
        }
        user.setUserId(UUID.randomUUID().toString());
        //Crypting password here!!!Hex  user.setPassword()...
        return userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> users() {
        return userRepository.findAll();
    }

    @Override
    public Role AddRole(Role role) {
        if (role == null){
            throw new RuntimeException("Role Object is Null");
        }
        return roleRepository.save(role);
    }

    @Override
    public void AddRoleToUser(String username, String rolename) {
        User user = getUser(username);
        Role role = getRole(rolename);
        System.out.println("************************"+user.getRoles()+"*************************");
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
    }

    @Override
    public Role getRole(String rolename) {
        return roleRepository.findByRoleName(rolename).orElse(null);
    }
    @Override
    public User autentication(String username, String password) {
        User user = getUser(username);
        if (user == null){
            throw new RuntimeException("User is null");
        }
        if (!Objects.equals(user.getUsername(), username) || !Objects.equals(user.getPassword(), password)){
            throw new RuntimeException("Bad credential");
        }
        return user;
    }
}
