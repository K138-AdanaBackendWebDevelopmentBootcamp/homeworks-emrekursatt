package patika.dev.week042.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.dev.week042.models.Course;
import patika.dev.week042.models.Instructor;
import patika.dev.week042.repository.IInstructorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    @Autowired
    IInstructorRepository iInstructorRepository;




    public Instructor saveInstructor(Instructor instructor) {

        return iInstructorRepository.save(instructor);
    }


    public List<Instructor> findAllInstructors() {

       return iInstructorRepository.findAll();
    }
}
