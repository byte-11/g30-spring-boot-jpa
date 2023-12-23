package uz.pdp.g30springjpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.pdp.g30springjpa.domain.Post;
import uz.pdp.g30springjpa.exception.DataNotFoundException;
import uz.pdp.g30springjpa.repo.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post getById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> DataNotFoundException.withId(id));
    }

    public List<Post> getAllByUserIdWithNativeQuery(Long userId) {
        return postRepository.findAllByUserIdWithNativeQuery(userId);
    }

    public List<Post> getAllByUserIdWithQuery(Long userId) {
        return postRepository.findAllByUserIdWithQuery(userId);
    }

    public List<Post> getAll() {
        Sort sort = Sort.by(
                Sort.Order.desc("userId"),
                Sort.Order.asc("id")
        );
        return postRepository.findAll(sort);
    }

    public Page<Post> getAllByPage(Integer size, Integer page) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findAll(pageable);
    }

    public Page<Post> getAllByPageWithNativeQuery(Integer size, Integer page) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findAllByPageWithNativeQuery(pageable);
    }

    public Page<Post> getAllByPageWithQuery(Integer size, Integer page) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findAllByPageWithQuery(pageable);
    }

    public Post getByIdAndUserId(Long id, Long userId) {
        return postRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> DataNotFoundException.withId(id));
    }

    public List<Post> getByTitle(String title){
        return postRepository.findAllByTitleContainingIgnoreCase(title);
    }
}
