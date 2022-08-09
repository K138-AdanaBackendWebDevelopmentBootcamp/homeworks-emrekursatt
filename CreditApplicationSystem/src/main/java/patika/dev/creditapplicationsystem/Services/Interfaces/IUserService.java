package patika.dev.creditapplicationsystem.Services.Interfaces;

import org.springframework.stereotype.Service;
import patika.dev.creditapplicationsystem.Models.User;

import java.util.List;

@Service
public interface IUserService {


    List<User> getAllUser();


    User saveUser(User user);


    User findById(Long id);

    User uptadeUser(Long id, User user);

    void deleteUser(Long id);
}