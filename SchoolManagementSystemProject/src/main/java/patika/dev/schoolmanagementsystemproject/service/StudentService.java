package patika.dev.schoolmanagementsystemproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.schoolmanagementsystemproject.models.Instructor;
import patika.dev.schoolmanagementsystemproject.models.Student;
import patika.dev.schoolmanagementsystemproject.repository.IStudentRepository;

import java.util.List;

@Service //We specify that the bean is a bean that will run in the business layer.
@RequiredArgsConstructor
public class StudentService {


    @Autowired //Thanks to the Spring framework IoC, it can be used with different binding methods (such as @Autowired, constructor)
    IStudentRepository iStudentRepository;

    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        return (List<Student>) iStudentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Student getStudent(int id) {
        return iStudentRepository.findById(id).get();
    }
    @Transactional(readOnly = true)
    public Student saveStudent(Student student) {
        return iStudentRepository.save(student);
    }
    @Transactional(readOnly = true)
    public Student uptadeStudent(Student student) {
        return iStudentRepository.save(student);
    }
    @Transactional(readOnly = true)
    public void deleteStudent(int id) {
        iStudentRepository.deleteById(id);
    }
    @Transactional(readOnly = true)
    public void deleteByStudentName(String studentName) {
        iStudentRepository.deleteByStudentName(studentName);
    }
}
