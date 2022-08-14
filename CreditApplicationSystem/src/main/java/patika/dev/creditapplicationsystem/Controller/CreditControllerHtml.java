package patika.dev.creditapplicationsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.creditapplicationsystem.Services.Interfaces.ICreditService;

@RestController
@RequiredArgsConstructor
public class CreditControllerHtml {

    private final ICreditService iCreditService;


    @GetMapping("/ApplyForCredit")
    public String askByIdentityNumber(@RequestParam long id){
        iCreditService.askByTcNumber(id);
        return "redirect:/home";
    }


}
