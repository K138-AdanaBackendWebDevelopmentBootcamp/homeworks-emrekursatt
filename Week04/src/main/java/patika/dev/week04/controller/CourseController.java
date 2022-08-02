package patika.dev.week04.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.dev.week04.models.Course;
import patika.dev.week04.service.CourseServiceImpl;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImpl iCourseService;


    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourse() {
        return new ResponseEntity<>(iCourseService.findAll(), HttpStatus.OK);


    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id) {
        return iCourseService.findById(id);


    }

    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {

        return new ResponseEntity<>((Course) iCourseService.save(course), HttpStatus.OK);


    }

    @PutMapping("/courses")
    public ResponseEntity<Course> uptadeCourse(@RequestBody Course course) {

        return new ResponseEntity<>((Course) iCourseService.uptade(course), HttpStatus.OK);


    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable int id) {
        iCourseService.deleteById(id);
        return "Deleted...";
    }

    @GetMapping("/courses/count")
    public int getAllCourseCount() {
        return iCourseService.getAllCourseCount();


    }

    @GetMapping("/courses/agegroup")
    public List<?> getAgeWithGroupİng() {
        return iCourseService.getAgeWithGroupİng();


    }

    @GetMapping("/courses/findByCourseName")
    List<Course> findByCourseName(String courseName) {
        return iCourseService.findByCourseName(courseName);
    }

    @GetMapping("/courses/findByCourseNameContaining")
    List<Course> findByCourseNameContaining(String str) {
        return iCourseService.findByCourseNameContaining(str);
    }

    @GetMapping("/courses/findByCreditScoreIsGreaterThan")
    List<Course> findByCreditScoreIsGreaterThan(int creditScore) {
        return iCourseService.findByCreditScoreIsGreaterThan(creditScore);
    }

    @GetMapping("/courses/find3ByCreditScoreIsGreaterThan")
    List<Course> findTopByCreditScoreIsGreaterThan(int creditScore) {
        return iCourseService.findTopByCreditScoreIsGreaterThan(creditScore);
    }

    @DeleteMapping("/courses/{courseName}")
    public String deleteByCourseName(@PathVariable String courseName) {
        iCourseService.deleteByCourseName(courseName);
        return "Deleted...";
    }
}