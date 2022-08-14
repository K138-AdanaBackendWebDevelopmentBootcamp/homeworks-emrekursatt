package patika.dev.creditapplicationsystem.Services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import patika.dev.creditapplicationsystem.Exception.*;
import patika.dev.creditapplicationsystem.Models.User;
import patika.dev.creditapplicationsystem.Repository.ICreditRepository;
import patika.dev.creditapplicationsystem.Repository.IUserRepository;
import patika.dev.creditapplicationsystem.Services.Interfaces.IUserService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    public  static String budgetUpdatedInfo= "";
    @Autowired
    private final   IUserRepository iUserRepository;
    @Autowired
    private final ICreditRepository icreditRepository;
    List<User> userList;


    @Override
    public List<User> getUsers(String sortBy, Boolean direction) {
        {
            switch (sortBy){
                case "fullName":
                case "identityNumber":
                case "salary":
                case"phoneNumber" :
                case"databaseId" :
                    this.userList = iUserRepository.findAll(Sort.by(direction?Sort.Direction.ASC:Sort.Direction.DESC,sortBy));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + sortBy);
            }
            return userList;
        }
    }

    @Override
    public User getUserByDbId(long id) {
        return iUserRepository.findById(id).get();
    }




    public User findUsersByTc(long tc) throws NotFoundException {
        if(iUserRepository.getUserByTc(tc)!=null)
            return  iUserRepository.getUserByTc(tc);
        else throw new NotFoundException("User NOT FOUND with national id "+tc);


    }

    @Override
    public User saveUser(User user) {


        User foundUserByTcNumber = (User) iUserRepository.getUserByTc(user.getTc());

        if(user.getId()==null) {

            if(foundUserByTcNumber!= null)
                throw new AlreadyExistsException("a user with identity number already exists :" + user.getTc() );
        }
        else {

            User theOldData = iUserRepository.findById(user.getTc()).get();
            if (foundUserByTcNumber != null) {
                if (!Objects.equals(user.getTc(), foundUserByTcNumber.getId()))
                    throw new AlreadyExistsException("a user with identity number already exists :" + user.getTc());

                else if(theOldData.getSalary()!=user.getSalary() && theOldData.getCredit_info()!=null){
                    icreditRepository.delete(theOldData.getCredit_info());

                    budgetUpdatedInfo = "The user's credit data needs to be updated. !";
                }
            }else {
                if(theOldData.getCredit_info()!=null) {
                    icreditRepository.delete(theOldData.getCredit_info());

                    budgetUpdatedInfo = "This user's credit data have to be updated because of changing occurred in user's identity number !";
                }
            }
        }


        validation(user);
        return iUserRepository.save(user);

    }

    @Override
    public User updateUserById(long id, User user) {
        User found = iUserRepository.findById(id).orElseThrow(()->new NotFoundException("a user with identity number: "+id+" Not found !"));
        validation(user);
        found.setCredit_info(user.getCredit_info());
        found.setFullName(user.getFullName());
        found.setTc(user.getTc());
        found.setSalary(user.getSalary());
        found.setPhoneNumber(user.getPhoneNumber());
        if(iUserRepository.getUserByTc(user.getTc()).getId()!=found.getId())
            throw new AlreadyExistsException("a user with identity number " + user.getId() + " Already exists !");

        return iUserRepository.save(found);
    }

    @Override
    public void deleteUserById(long id) {
        iUserRepository.findById(id).orElseThrow(()->new NotFoundException("a user with database Id: "+id+" Not found !"));
        iUserRepository.deleteById(id);
    }

    @SneakyThrows
    private void validation(User user){

        if(user.getTc()%2==1)throw new Invalid_ID_NumberException("the user's ID number is NOT VALID number it must end with even digit ! ");

        if (user.getTc()<10000000000L || user.getTc()>99999999999L)
            throw new IdentityNumber11digitException("Identity number must have 11 digit like : 12345678901");
        if(Objects.equals(user.getFullName(), ""))
            throw new FullnameEmptyException("Full name should have at least one character");
        if (user.getPhoneNumber()<1000000000|| user.getPhoneNumber()>9999999999L)
            throw new PhoneNumber10digitException("Phone number must have 10 digit like : 1234567890");
    }
}
































