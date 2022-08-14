package patika.dev.creditapplicationsystem.Services.Interfaces;

import org.springframework.stereotype.Service;
import patika.dev.creditapplicationsystem.Models.User;

import java.util.List;

@Service
public interface IUserService {
    public List<User> getUsers(String sortBy, Boolean ascending);

    public User getUserByDbId(long databaseId);

    public User findUsersByTc(long tc);

    public User saveUser(User user);

    public User updateUserById(long id, User user);

    void deleteUserById(long id);


















    /*List<User> getAllUser();


    User saveUser(User user);


    User findById(Long id);

    User uptadeUser(Long id, User user);

    void deleteUser(Long id);*/
}