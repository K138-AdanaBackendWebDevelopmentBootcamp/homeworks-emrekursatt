package patika.dev.schoolmanagementsystemproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.schoolmanagementsystemproject.models.Instructor;
import patika.dev.schoolmanagementsystemproject.repository.IInstructorRepository;

import java.util.List;
import java.util.Optional;

@Service //We specify that the bean is a bean that will run in the business layer.
@RequiredArgsConstructor
public class InstructorService {

    @Autowired //Thanks to the Spring framework IoC, it can be used with different binding methods (such as @Autowired, constructor)
    IInstructorRepository iInstructorRepository;

    @Transactional(readOnly = true)
    public List<Instructor> findAllInstructor() {
        return (List<Instructor>) iInstructorRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Instructor getInstructor(int id) {
        return iInstructorRepository.findById(id).get();
    }

    public List<Instructor> findByInstructorName(String instructorName) {
        return  iInstructorRepository.findByInstructorName(instructorName);
    }
    @Transactional(readOnly = true)
    public List<Instructor> findBySalaryIsGreaterThan(int salary) {
       return iInstructorRepository.findBySalaryIsGreaterThan(salary);
    }
    @Transactional(readOnly = true)
    public Instructor saveInstructor(Instructor instructor) {
        return iInstructorRepository.save(instructor);
    }
    @Transactional(readOnly = true)
    public Instructor uptadeInstructor(Instructor instructor) {
        return iInstructorRepository.save(instructor);
    }
    @Transactional(readOnly = true)
    public void deleteInstructor(int id) {
        iInstructorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public void deleteByInstructorName(String instructorName) {
        iInstructorRepository.deleteByInstructorName(instructorName );
    }


}
