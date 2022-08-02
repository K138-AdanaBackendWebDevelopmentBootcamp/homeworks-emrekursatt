package patika.dev.week042.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patika.dev.week042.models.Course;
import patika.dev.week042.service.CourseService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping("/courses")
    public List<Course> getAllCourses(){

        return courseService.findAllCourses();
    }

    @GetMapping("/courses/id")
    public Course getCourse(@RequestParam int id){
        return courseService.getCourse(id);

    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course)   {
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/courses/id")
    public String deleteCourse(@RequestParam int id)   {
        courseService.deleteCustomer(id);
        return ("Deleted....");
    }

}