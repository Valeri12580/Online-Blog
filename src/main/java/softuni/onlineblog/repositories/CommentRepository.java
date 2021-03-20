package softuni.onlineblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.onlineblog.domain.entities.Comment;

@Repository
public interface CommentRepository  extends JpaRepository<Comment,String> {
}
