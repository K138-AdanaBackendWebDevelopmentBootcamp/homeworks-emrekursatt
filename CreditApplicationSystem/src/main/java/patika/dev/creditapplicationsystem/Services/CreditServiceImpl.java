package patika.dev.creditapplicationsystem.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.dev.creditapplicationsystem.Models.Credit;
import patika.dev.creditapplicationsystem.Models.User;
import patika.dev.creditapplicationsystem.Repository.ICreditRepository;
import patika.dev.creditapplicationsystem.Repository.IUserRepository;
import patika.dev.creditapplicationsystem.Services.Interfaces.ICreditService;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements ICreditService {

    @Autowired
    ICreditRepository iCreditRepository;
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public Credit findByTcNumber(long id) {
        User foundUser = iUserRepository.getUserByTc(id);

        Credit credit = applyCreditScore(id);
        credit.setUser(foundUser);

        learnCreditLimit(credit);

        return iCreditRepository.save(credit);
    }




    private Credit applyCreditScore(long id) {
        String stringİd = Long.toString(id);
        byte a = Byte.parseByte(String.valueOf(stringİd.charAt(stringİd.length() - 1)));
        Credit credit = new Credit();

        switch (a) {
            case 0:
                credit.setCreditScore(2000);
                break;
            case 2:
                credit.setCreditScore(550);
                break;
            case 4:
                credit.setCreditScore(1000);
                break;
            case 6:
                credit.setCreditScore(400);
                break;
            case 8:
                credit.setCreditScore(900);
                break;
            default:
                credit.setCreditScore(0);
                throw new RuntimeException(id + " is WRONG ID !");
        }
        return credit;

    }


    private String learnCreditLimit(Credit credit) {

        int creditLimitMultiplier = 4;

        if (credit.getCreditScore() < 500) {
            return "Credit Not Approved";
        } else if (credit.getCreditScore() >= 500 && credit.getCreditScore() < 1000 && credit.getUser().getSalary() < 5000) {
            credit.setCreditLimit(10000);
            return "Credit Approved";
        } else if (credit.getCreditScore() >= 500 && credit.getCreditScore() < 1000 && credit.getUser().getSalary() >= 5000) {
            credit.setCreditLimit(2000);
            return "Credit Approved";
        } else if (credit.getCreditScore() >= 1000) {
            credit.setCreditLimit((int) (credit.getUser().getSalary() * creditLimitMultiplier));
        }
        return null;
    }

    @Override
    public Credit findByIdNumber(long id) {
        return iCreditRepository.findById(id).get();
    }

}