package patika.dev.creditapplicationsystem.Services.Interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patika.dev.creditapplicationsystem.Models.Credit;

@Service
public interface ICreditService {

    public Credit askByTcNumber(long idCardNumber);

    public Credit getCreditByUserIdentityNumber(long idCardNumber);
}