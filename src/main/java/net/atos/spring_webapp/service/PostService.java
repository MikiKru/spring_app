package net.atos.spring_webapp.service;

import net.atos.spring_webapp.model.Post;
import net.atos.spring_webapp.repository.PostRepository;
import net.atos.spring_webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;
    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    public List<Post> getAllPostsOrdered(Sort.Direction direction){
        return postRepository.findAll(Sort.by(direction,"addedDate"));
    }
    public Post getPostbyId(long postId){
        Post post = null;
        Optional<Post> postOptional = postRepository.findById(postId);
        if(postOptional.isPresent()){
            post = postOptional.get();
        }
        return post;
    }
    public void addNewPost(long userId, Post post){
        post.setAuthor(userRepository.findById(userId).get());
        postRepository.save(post);
    }

}
