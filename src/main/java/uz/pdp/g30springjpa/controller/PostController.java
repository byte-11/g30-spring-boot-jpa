package uz.pdp.g30springjpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.g30springjpa.service.PostService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(postService.getById(id));
    }

    @GetMapping("/user/native/{userId}")
    public ResponseEntity<?> getAllByUserIdWithNativeQuery(@PathVariable Long userId){
        return ResponseEntity.ok(postService.getAllByUserIdWithNativeQuery(userId));
    }

    @GetMapping("/user/query/{userId}")
    public ResponseEntity<?> getAllByUserIdWithQuery(@PathVariable Long userId){
        return ResponseEntity.ok(postService.getAllByUserIdWithQuery(userId));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/pageable")
    public ResponseEntity<?> getAllByPage(@RequestParam Integer size, @RequestParam Integer page){
        return ResponseEntity.ok(postService.getAllByPage(size, page));
    }

    @GetMapping("/pageable/native")
    public ResponseEntity<?> getAllByPageWithNativeQuery(@RequestParam Integer size, @RequestParam Integer page){
        return ResponseEntity.ok(postService.getAllByPageWithNativeQuery(size, page));
    }

    @GetMapping("/pageable/query")
    public ResponseEntity<?> getAllByPageWithQuery(@RequestParam Integer size, @RequestParam Integer page){
        return ResponseEntity.ok(postService.getAllByPageWithQuery(size, page));
    }

    @GetMapping("/{id}/{userId}")
    public ResponseEntity<?> getByIdAndUserId(
            @PathVariable Long id,
            @PathVariable Long userId
    ){
        return ResponseEntity.ok(postService.getByIdAndUserId(id, userId));
    }

    @GetMapping("/title")
    public ResponseEntity<?> getByTitleContent(
            @RequestParam String title
    ){
        return ResponseEntity.ok(postService.getByTitle(title));
    }

}
