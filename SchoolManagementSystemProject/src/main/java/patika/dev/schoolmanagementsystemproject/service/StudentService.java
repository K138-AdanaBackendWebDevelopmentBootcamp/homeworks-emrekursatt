package patika.dev.schoolmanagementsystemproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.dev.schoolmanagementsystemproject.repository.IStudentRepository;

@Service //We specify that the bean is a bean that will run in the business layer.
@RequiredArgsConstructor
public class StudentService {


    @Autowired //Thanks to the Spring framework IoC, it can be used with different binding methods (such as @Autowired, constructor)
    IStudentRepository studentRepository;

}
