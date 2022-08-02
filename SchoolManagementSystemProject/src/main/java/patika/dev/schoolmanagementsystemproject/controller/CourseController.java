package patika.dev.schoolmanagementsystemproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patika.dev.schoolmanagementsystemproject.models.Course;
import patika.dev.schoolmanagementsystemproject.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CourseController {

    @Autowired //Thanks to the Spring framework IoC, it can be used with different binding methods (such as @Autowired, constructor)
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.findAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id){
        return courseService.getCourse(id);
    }

    @GetMapping("/findByCourseName")
    List<Course> findByCourseName(String courseName){
        return courseService.findByCourseName(courseName);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @PutMapping("/courses")
    public Course uptadeCourse(@RequestBody Course course){
        return courseService.uptadeCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
        return ("Deleted....");
    }

    @DeleteMapping("/deleteByCourseName")
    public String deleteByCourseName(@PathVariable String courseName){
        courseService.deleteByCourseName(courseName);
        return ("Deleted....");
    }



    @GetMapping("/findByCreditScoreIsGreaterThan")
    List<Course> findByCreditScoreIsGreaterThan(int creditScore){
        return courseService.findByCreditScoreIsGreaterThan(creditScore);
}








}