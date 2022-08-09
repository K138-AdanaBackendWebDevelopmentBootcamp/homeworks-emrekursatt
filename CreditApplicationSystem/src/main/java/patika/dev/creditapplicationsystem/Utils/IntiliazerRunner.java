//package patika.dev.creditapplicationsystem.Utils;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import patika.dev.creditapplicationsystem.Models.User;
import patika.dev.creditapplicationsystem.Repository.IUserRepository;


/*@Component
@RequiredArgsConstructor
public class IntiliazerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(IntiliazerRunner.class);

    @Autowired
    private final IUserRepository iUserRepository;


    @Override
    public void run(String... args) throws Exception {


            iUserRepository.deleteAll();

            iUserRepository.save(User.builder().tc(123456780).fullName("Emre").phoneNumber("0507856265").salary(10000).build());
            iUserRepository.save(User.builder().tc(989765412).fullName("Kürşat").phoneNumber("0507568948").salary(15000).build());
            iUserRepository.save(User.builder().tc(554578454).fullName("Burak").phoneNumber("05075984566").salary(8000).build());
            iUserRepository.save(User.builder().tc(659416546).fullName("Samet").phoneNumber("05079894655").salary(7000).build());

            iUserRepository.findAll().forEach(user -> logger.info("{}" , user));

        }
    }

*/