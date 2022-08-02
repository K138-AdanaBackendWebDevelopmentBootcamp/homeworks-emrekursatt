package patika.dev.week042.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.dev.week042.exception.CourseNotExistException;
import patika.dev.week042.models.Course;
import patika.dev.week042.repository.ICourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService  {

    @Autowired
    ICourseRepository iCourseRepository;
    public List<Course> findAllCourses() {

        return  iCourseRepository.findAll();
    }

    public Course getCourse(int id) {

        return iCourseRepository.findCourse(id);
    }


    public Course saveCourse(Course course) {
        /*Course isCourseExist = iCourseRepository.findCourseByCode(course.getCreditScore());

        if (isCourseExist != null) {
            throw new CourseAlreadyExistException("Customer is exist with code :" + course.getCreditScore());
        }*/
        return iCourseRepository.save(course);
    }

    public void deleteCustomer(int id) {
        Course isCourseExist = iCourseRepository.findCourse(id);

        if (isCourseExist == null) {
            throw new CourseNotExistException("Course with id  :" + id);
        }

        iCourseRepository.delete(isCourseExist);
    }
}
