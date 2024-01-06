package uz.pdp.g30springjpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.g30springjpa.domain.Comment;
import uz.pdp.g30springjpa.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Comment save(@RequestBody Comment comment){
        return commentService.saveComment(comment);
    }

    @PutMapping
    public Comment update(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    @GetMapping
    public List<Comment> getAll(){
        return commentService.getAllComments();
    }

}
