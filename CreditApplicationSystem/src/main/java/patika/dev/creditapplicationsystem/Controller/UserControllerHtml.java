package patika.dev.creditapplicationsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import patika.dev.creditapplicationsystem.Models.User;
import patika.dev.creditapplicationsystem.Services.Interfaces.ICreditService;
import patika.dev.creditapplicationsystem.Services.Interfaces.IUserService;
import patika.dev.creditapplicationsystem.Services.UserServiceImpl;

import java.util.List;




@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class UserControllerHtml {

    private String budgetUpdatedInfo= "";
    public String excMsg;

    private final IUserService iUserService;

    @GetMapping(value = "")
    @Transactional(readOnly = true)
    public String getUsers(Model model,@RequestParam(required = false,defaultValue = "id") String sortBy,@RequestParam(required = false,defaultValue = "true") Boolean ascending){
        List<User> userList = iUserService.getUsers(sortBy, ascending);
        model.addAttribute("excMsg",excMsg);
        model.addAttribute("BUI",budgetUpdatedInfo);
        model.addAttribute("users",userList);
        budgetUpdatedInfo="";
        excMsg="";
        return "home";
    }



    @RequestMapping(value = "/saveuser",method = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST})
    @Transactional
    public String saveUser( User user, Model model ) {
        try {
            iUserService.saveUser(user);
            budgetUpdatedInfo = UserServiceImpl.budgetUpdatedInfo;
        }catch (Exception
                e){
            model.addAttribute("error",e);
            excMsg = e.getMessage();
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/delete_user",method ={ RequestMethod.DELETE,RequestMethod.GET})
    public String deleteUserById(@RequestParam(required = false) long id){
        iUserService.deleteUserById(id);
        return "redirect:/home";
    }

}