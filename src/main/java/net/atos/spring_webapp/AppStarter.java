package net.atos.spring_webapp;

import net.atos.spring_webapp.model.User;
import net.atos.spring_webapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AppStarter implements CommandLineRunner {
    private UserRepository userRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private PermissionRepository permissionRepository;
    private MessageRepository messageRepository;

    @Autowired
    public AppStarter(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository, PermissionRepository permissionRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.permissionRepository = permissionRepository;
        this.messageRepository = messageRepository;
    }
    private void printUsers(List<User> users){
        users.stream().forEach(
                user -> System.out.printf("|%10d|%10s|%10s|%10b|%15s|\n",
                        user.getUserId(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getEnable(),
                        user.getRegisterDate())
        );
    }

    private void getAllUsers(){
        // wypisz wszystkich użytkowników
        List<User> users = userRepository.findAll();
        printUsers(users);
    }
    private void getAllUsersSortedByEmail(){
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "registerDate"));
        printUsers(users);
    }
    @Override
    public void run(String... args) throws Exception {
        getAllUsersSortedByEmail();
    }
}
