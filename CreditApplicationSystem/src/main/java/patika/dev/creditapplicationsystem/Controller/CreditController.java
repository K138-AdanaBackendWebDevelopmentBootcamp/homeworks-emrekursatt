package patika.dev.creditapplicationsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.creditapplicationsystem.Models.Credit;
import patika.dev.creditapplicationsystem.Services.Interfaces.ICreditService;

@RestController
@RequiredArgsConstructor
public class CreditController {

    @Autowired
    private final ICreditService iCreditService;


    @GetMapping("/credit/findByTcNumber")
    public Credit findByTcNumber  (@PathVariable long id) {
        return iCreditService.findByTcNumber(id);
    }

    @GetMapping("/credit/{idnumber}")
    public Credit findByIdNumber (@PathVariable long id) {
        return iCreditService.findByIdNumber(id);
    }

}


