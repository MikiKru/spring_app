package net.atos.spring_webapp.service;

import net.atos.spring_webapp.model.Permission;
import net.atos.spring_webapp.model.User;
import net.atos.spring_webapp.repository.PermissionRepository;
import net.atos.spring_webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private PermissionRepository permissionRepository;
    @Autowired
    public UserService(UserRepository userRepository, PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
    }
    public User assignPermissionToUser(User user, int roleId){
        Optional<Permission> permission = permissionRepository.findById((byte) roleId);
        if (permission.isPresent()) {
            user.addPermission(permission.get());
        }
        return user;
    }
    public void registerUser(User user){
        userRepository.save(assignPermissionToUser(user, 1));
    }
}
