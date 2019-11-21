package net.atos.spring_webapp.controller;

import net.atos.spring_webapp.model.User;
import net.atos.spring_webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/")
    public String allPosts(Model model){
        model.addAttribute("user", new User("X","X"));
        model.addAttribute("posts", postService.getAllPostsOrdered(Sort.Direction.DESC));
        return "index";     // -> nazwa widoku html
    }
}
