package patika.dev.creditapplicationsystem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.creditapplicationsystem.Models.User;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    public User getUserByTc(long tc);


    public User getUserByIdentityNumber(long tc);
}
