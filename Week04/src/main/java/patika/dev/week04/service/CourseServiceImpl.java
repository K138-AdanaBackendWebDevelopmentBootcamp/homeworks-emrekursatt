package patika.dev.week04.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import patika.dev.week04.models.Course;
import patika.dev.week04.repository.ICourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl  {


    final ICourseRepository iCourseRepository;
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        Iterable<Course> courseIterable = iCourseRepository.findAll();
        courseIterable.iterator().forEachRemaining(new Consumer<Course>() {
            @Override
            public void accept(Course course) {
                courses.add(course);
            }
        });
        return courses;
    }

    @Transactional(readOnly = true)
    public Course save(Course course) {
        return iCourseRepository.save(course);

    }
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return iCourseRepository.findById(id).get();

    }
    @Transactional(readOnly = true)
    public Course uptade(Course course) {
        return iCourseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public void deleteById(int id) {
    iCourseRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public int getAllCourseCount() {
     return  iCourseRepository.getNumberofCourse();
    }

    public List<?> getAgeWithGroupİng() {
    return iCourseRepository.getAgeWithGroupİng();
    }


    public List<Course> findByCourseName(String courseName) {
    return iCourseRepository.findByCourseName(courseName);
    }

    public List<Course> findByCourseNameContaining(String str) {
    return iCourseRepository.findByCourseNameContaining(str);
    }

    public List<Course> findByCreditScoreIsGreaterThan(int creditScore) {
    return iCourseRepository.findByCreditScoreIsGreaterThan(creditScore);
    }


    public List<Course> findTopByCreditScoreIsGreaterThan(int creditScore) {
    return iCourseRepository.findTopByCreditScoreIsGreaterThan(creditScore);
    }
    @Transactional
    public void deleteByCourseName(String courseName) {
        iCourseRepository.deleteByCourseName(courseName);
    }
}
