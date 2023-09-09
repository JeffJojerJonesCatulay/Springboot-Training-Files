package sb.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.security.entity.User;

@Repository
// <Post, Long> Name of entity and data type of primary key
public interface UserRepository extends JpaRepository<User, Long> {

}
