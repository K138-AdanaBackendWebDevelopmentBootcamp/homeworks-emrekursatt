package patika.dev.creditapplicationsystem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import patika.dev.creditapplicationsystem.Models.User;
import patika.dev.creditapplicationsystem.Services.Interfaces.IUserService;
import patika.dev.creditapplicationsystem.Services.UserServiceImpl;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private final IUserService iUserService;

    public UserController( IUserService iUserService) {
        this.iUserService = iUserService;

    }


    @GetMapping("/users")
    public List<User> getAllUser(){
    return  iUserService.getAllUser();

    }

    @GetMapping("/users/finById")
    public User findById( Long id){
        return  iUserService.findById(id);
    }
    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return iUserService.saveUser(user);
    }
    @PutMapping("/users/{id}")
    public User uptadeUser(@PathVariable Long id ,@RequestBody User user){
        return iUserService.uptadeUser(id,user);
    }

    @DeleteMapping("/users/deleteById")
    public String deleteUser(@PathVariable Long id){
        iUserService.deleteUser(id);
        return "Deleted";
    }

}






