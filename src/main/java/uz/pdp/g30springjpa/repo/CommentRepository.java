package uz.pdp.g30springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.g30springjpa.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
