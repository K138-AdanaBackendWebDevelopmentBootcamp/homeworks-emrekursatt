package patika.dev.week03.service;

import patika.dev.week03.dao.Interface.IStudentDAO;
import patika.dev.week03.models.Student;
import patika.dev.week03.service.Interface.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService<Student> {


    IStudentDAO iStudentDAO;

    public StudentServiceImpl(IStudentDAO iStudentDAO) {
        this.iStudentDAO = iStudentDAO;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return (Student) iStudentDAO.save(student);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Student uptadeOnDatabese(Student student) {
        return null;
    }
}
