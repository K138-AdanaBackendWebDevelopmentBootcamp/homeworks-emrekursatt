package patika.dev.week042.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.week042.models.Course;
import patika.dev.week042.models.Instructor;
import patika.dev.week042.service.InstructorService;

import java.util.List;

@RestController
public class InstructorContreller {

    @Autowired
   InstructorService instructorService;

    @GetMapping("/intructors")
    public List<Instructor> getAllInstructor(){

        return instructorService.findAllInstructors();
    }

    @PostMapping("/intructors")
    public Instructor saveCourse(@RequestBody Instructor instructor)   {
        return instructorService.saveInstructor(instructor);
    }


}
