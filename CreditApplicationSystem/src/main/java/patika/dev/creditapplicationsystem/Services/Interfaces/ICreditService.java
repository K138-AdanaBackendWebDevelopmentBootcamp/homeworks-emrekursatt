package patika.dev.creditapplicationsystem.Services.Interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patika.dev.creditapplicationsystem.Models.Credit;

@Service
public interface ICreditService {
    Credit findByTcNumber(long id);

    Credit findByIdNumber(long id);
}
