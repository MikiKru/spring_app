package net.atos.spring_webapp.service;

import net.atos.spring_webapp.model.User;
import net.atos.spring_webapp.repository.PermissionRepository;
import net.atos.spring_webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PermissionRepository permissionRepository;
    @Autowired
    public UserService(UserRepository userRepository, PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
    }
    public User assignPermissionToUser(User user, byte roleId){
        user
        return
    }

    public void registerUser(User user){

    }
}
