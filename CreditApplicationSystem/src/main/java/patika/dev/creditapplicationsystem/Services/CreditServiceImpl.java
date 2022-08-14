package patika.dev.creditapplicationsystem.Services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.dev.creditapplicationsystem.Exception.CreditInfoNotFoundException;
import patika.dev.creditapplicationsystem.Exception.NotFoundException;
import patika.dev.creditapplicationsystem.Models.Credit;
import patika.dev.creditapplicationsystem.Models.State;
import patika.dev.creditapplicationsystem.Models.User;
import patika.dev.creditapplicationsystem.Repository.ICreditRepository;
import patika.dev.creditapplicationsystem.Repository.IUserRepository;
import patika.dev.creditapplicationsystem.Services.Interfaces.ICreditService;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements ICreditService {

    private final IUserRepository iUserRepository;
    private final ICreditRepository creditRepository;




    @Override
    public Credit askByTcNumber(long tc) {
        User foundUser = iUserRepository.getUserByTc(tc);
        if (foundUser == null)
            throw new NotFoundException("Not found user with id " + tc);

        Credit credit = defineCreditScore(tc);
        credit.setUser(foundUser);

        setStateAndLimit(credit);

        return creditRepository.save(credit);
    }

    @SneakyThrows
    @Override
    public Credit getCreditByUserIdentityNumber(long tc) {
        User foundUser = iUserRepository.getUserByIdentityNumber(tc);
        if (foundUser == null)
            throw new NotFoundException("Not found user with id " + tc);
        if (foundUser.getCredit_info() == null)
            throw new CreditInfoNotFoundException("the user with identity number : " + tc + " doesn't have Credit information !");
        return foundUser.getCredit_info();
    }

    private Credit defineCreditScore(long identityNumber) {
        String str_id = Long.toString(identityNumber);
        byte n = Byte.parseByte(String.valueOf(str_id.charAt(str_id.length() - 1)));
        Credit credit = new Credit();

        switch (n) {
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
                throw new RuntimeException(identityNumber + " is WRONG ID !");
        }
        return credit;
    }

    private void setStateAndLimit(Credit credit) {
        {
            if (credit.getCreditScore() < 500)
                credit.setState(State.failure);
            else if (credit.getCreditScore() >= 500 && credit.getCreditScore() < 1000 && credit.getUser().getSalary() < 5000) {
                credit.setState(State.success);
                credit.setCreditLimit(10_000);
            } else if (credit.getCreditScore() >= 500 && credit.getCreditScore() < 1000 && credit.getUser().getSalary() >= 5000) {
                credit.setState(State.success);
                credit.setCreditLimit(20_000);
            } else if (credit.getCreditScore() >= 1000) {
                credit.setState(State.success);
                credit.setCreditLimit(credit.getUser().getSalary() * credit.getCreditLimitMultiplier());
            }
        }
    }




}