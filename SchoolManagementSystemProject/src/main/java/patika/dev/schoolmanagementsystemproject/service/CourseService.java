package patika.dev.schoolmanagementsystemproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.schoolmanagementsystemproject.models.Course;
import patika.dev.schoolmanagementsystemproject.repository.ICourseRepository;

import java.util.List;

@Service //We specify that the bean is a bean that will run in the business layer.
@RequiredArgsConstructor
public class CourseService {

    @Autowired //Thanks to the Spring framework IoC, it can be used with different binding methods (such as @Autowired, constructor)
    ICourseRepository iCourseRepository;

    @Transactional(readOnly = true)
    public List<Course> findAllCourses() {
        return (List<Course>) iCourseRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Course getCourse(int id) {
        return  iCourseRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public Course saveCourse(Course course) {

        return iCourseRepository.save(course);
    }
    @Transactional(readOnly = true)
    public Course uptadeCourse(Course course) {
        return iCourseRepository.save(course);
    }
    @Transactional(readOnly = true)
    public void deleteCourse(int id) {
        iCourseRepository.deleteById(id);

    }
    @Transactional(readOnly = true)

    public List<Course> findByCourseName(String course) {
        return iCourseRepository.findByCourseName(course);
    }
    @Transactional(readOnly = true)
    public List<Course> findByCreditScoreIsGreaterThan(int creditScore) {
        return iCourseRepository.findByCreditScoreIsGreaterThan(creditScore);
    }
    @Transactional(readOnly = true)
    public void deleteByCourseName(String courseName) {

        iCourseRepository.deleteByCourseName(courseName);
    }
}
