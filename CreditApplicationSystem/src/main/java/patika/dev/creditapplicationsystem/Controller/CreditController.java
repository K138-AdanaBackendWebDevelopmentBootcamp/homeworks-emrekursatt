package patika.dev.creditapplicationsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.creditapplicationsystem.Models.Credit;
import patika.dev.creditapplicationsystem.Services.Interfaces.ICreditService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/json/users")
public class CreditController {

    private final ICreditService iCreditService;


    @GetMapping("/ApplyForCredit/{idCardNumber}")
    public ResponseEntity askByTcNumber(@PathVariable long idCardNumber){
            return new  ResponseEntity (iCreditService.askByTcNumber(idCardNumber) , HttpStatus.OK);

    }

    @GetMapping("/Credit/{idCardNumber}")
    @Transactional(readOnly = true)
    public ResponseEntity getCreditByUserIdentityNumber(@PathVariable long idCardNumber){

            return new ResponseEntity(iCreditService.getCreditByUserTcNumber(idCardNumber),HttpStatus.OK);


    }


}


