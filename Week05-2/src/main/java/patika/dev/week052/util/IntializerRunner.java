package patika.dev.week052.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import patika.dev.week052.entitiy.User;
import patika.dev.week052.repository.UserRepository;

@Component
public class IntializerRunner implements CommandLineRunner {


    private static final Logger logger = LoggerFactory.getLogger(IntializerRunner.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();


        userRepository.save(User.builder().name("Emre").age(27).email("Emre@com").build());
        userRepository.save(User.builder().name("Nur").age(28).email("Nur@com").build());
        userRepository.save(User.builder().name("Burak").age(28).email("Burak@com").build());
        userRepository.save(User.builder().name("Aycan").age(26).email("Aycan@com").build());

        userRepository.findAll().forEach(user -> logger.info("{}" , user));

    }
}
