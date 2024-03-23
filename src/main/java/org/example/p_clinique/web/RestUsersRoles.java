package org.example.p_clinique.web;

import lombok.AllArgsConstructor;
import org.example.p_clinique.entities.User;
import org.example.p_clinique.service.IUserRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestUsersRoles {
    private IUserRoleService userRoleService;
    @GetMapping("/users")
    private List<User>list(){
        return userRoleService.users();
    }

    @GetMapping("/user/{username}")
    private User getUser(@PathVariable(name = "username") String username){
        return userRoleService.getUser(username);
    }
}
