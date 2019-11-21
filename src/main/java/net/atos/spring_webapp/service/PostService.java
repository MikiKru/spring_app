package net.atos.spring_webapp.service;

import net.atos.spring_webapp.model.Post;
import net.atos.spring_webapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PostService {
    private PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<Post> getAllPostsOrdered(Sort.Direction direction){
        return postRepository.findAll(Sort.by(direction,"addedDate"));
    }

}
