package store.bizscanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.bizscanner.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
