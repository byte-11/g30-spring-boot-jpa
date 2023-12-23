package uz.pdp.g30springjpa.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.g30springjpa.domain.Post;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.userId=?1")
    List<Post> findAllByUserIdWithQuery(Long userId);

    @Query(nativeQuery = true, value = "SELECT p.* FROM post p WHERE p.user_id=?1")
    List<Post> findAllByUserIdWithNativeQuery(Long userId);

    @Query("SELECT p FROM Post p")
    Page<Post> findAllByPageWithQuery(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT p.* FROM post p")
    Page<Post> findAllByPageWithNativeQuery(Pageable pageable);

    Optional<Post> findByIdAndUserId(Long userId, Long id);

    List<Post> findAllByTitleContainingIgnoreCase(String title);
}
