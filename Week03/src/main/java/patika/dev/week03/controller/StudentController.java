package patika.dev.week03.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import patika.dev.week03.models.Course;
import patika.dev.week03.service.Interface.IStudentService;

import java.util.List;

public class StudentController {

    IStudentService iStudentService;

    @GetMapping("/students")
    public ResponseEntity<List<Course>> getAllStudent() {
        return new ResponseEntity<>(iStudentService.findAll(), HttpStatus.OK);


    }

    @PostMapping("/students")
    public ResponseEntity<Course> saveStundent(@RequestBody Course course) {

        return new ResponseEntity<>((Course) iStudentService.save(course), HttpStatus.OK);


    }


}
