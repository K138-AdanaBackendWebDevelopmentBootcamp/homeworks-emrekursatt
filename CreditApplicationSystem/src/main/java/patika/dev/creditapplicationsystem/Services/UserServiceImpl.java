package patika.dev.creditapplicationsystem.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.creditapplicationsystem.Models.User;
import patika.dev.creditapplicationsystem.Repository.IUserRepository;
import patika.dev.creditapplicationsystem.Services.Interfaces.IUserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;


    @Override
    @Transactional( readOnly = true)
    public List<User> getAllUser() {
        return (List<User>) iUserRepository.findAll();
    }


    @Override
    public User saveUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public User uptadeUser(Long id, User user) {
        Optional<User> user1 =  iUserRepository.findById(id);
        if (user1.isPresent()){
            user1.get().setId(id);
            user1.get().setFullName(user.getFullName());
            user1.get().setSalary(user.getSalary());
            user1.get().setTc(user.getTc());
            user1.get().setPhoneNumber(user.getPhoneNumber());
            return iUserRepository.save(user1.get());
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        iUserRepository.deleteById(id);
    }


}




