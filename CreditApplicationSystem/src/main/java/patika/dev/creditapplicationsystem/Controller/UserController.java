package patika.dev.creditapplicationsystem.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import patika.dev.creditapplicationsystem.Models.User;
import patika.dev.creditapplicationsystem.Services.Interfaces.IUserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final IUserService iUserService;


    @GetMapping("/db/(users)")
    @Transactional(readOnly = true)
    public ResponseEntity getUsers(@RequestParam(required = false,defaultValue = "id") String sortBy,@RequestParam(required = false,defaultValue = "true") Boolean ascending){

            return new  ResponseEntity (iUserService.getUsers(sortBy, ascending),HttpStatus.OK);


    }


    @GetMapping("/dbId")
    @Transactional(readOnly = true)
    public ResponseEntity getUserByDbId(@PathVariable long id){

            return  new ResponseEntity (iUserService.getUserByDbId(id),HttpStatus.OK);

    }
    @GetMapping("/IdCardNumber")
    @Transactional(readOnly = true)
    public ResponseEntity findUsersByTc(@PathVariable long tc){

            return new ResponseEntity (iUserService.findUsersByTc(tc),HttpStatus.OK);

    }
    @PostMapping
    @Transactional
    public ResponseEntity saveUser(@RequestBody User user){

            return  ResponseEntity.ok(iUserService.saveUser(user));


    }
    @PutMapping("/uptadeid")
    @Transactional
    public ResponseEntity updateUserById(@PathVariable long id, @RequestBody User user){

        return new  ResponseEntity(iUserService.updateUserById(id,user), HttpStatus.OK);
    }

    @DeleteMapping("/databaseId")
    @Transactional
    public String deleteUserById(@PathVariable long  id){
            iUserService.deleteUserById(id);
            return ("Deleted....");

    }
}