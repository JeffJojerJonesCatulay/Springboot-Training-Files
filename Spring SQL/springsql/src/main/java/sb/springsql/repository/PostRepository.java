package sb.springsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.springsql.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
