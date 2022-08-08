package patika.dev.week052.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.week052.entitiy.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
