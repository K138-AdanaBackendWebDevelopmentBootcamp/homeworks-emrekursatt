package patika.dev.week052.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import patika.dev.week052.entitiy.User;
import patika.dev.week052.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/index")
    public String showUserList(Model theModel){
        theModel.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String signupPage(User user){
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user , BindingResult result,Model theModel){
        if (result.hasErrors()){
            return "adduser";
        }

        userRepository.save(user);
        return "redirect://index";

    }

    @GetMapping("/edit/{id}")
    public String uptadePage(@PathVariable int id , Model theModel){

        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User id : " +id));
        theModel.addAttribute("user" , user);
        return "uptadeuser";
    }

    @PostMapping("/uptade/{id}")
    public String uptadeUser(@PathVariable int id , @Valid User user , BindingResult result , Model thmeModel){
        if (result.hasErrors()){
            return "uptadeuser";


        }
        userRepository.save(user);
        return "redirect:/index";
    }
    @GetMapping ("/delete/{id}")
    public String deleteUser (@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid user : " + id));
        userRepository.delete(user);
        return "redirect:/index";
    }
}



