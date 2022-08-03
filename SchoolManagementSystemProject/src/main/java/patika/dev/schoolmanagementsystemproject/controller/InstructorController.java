package patika.dev.schoolmanagementsystemproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patika.dev.schoolmanagementsystemproject.models.Instructor;
import patika.dev.schoolmanagementsystemproject.service.InstructorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    @Autowired //Thanks to the Spring framework IoC, it can be used with different binding methods (such as @Autowired, constructor)
    InstructorService instructorService;

    @GetMapping("/Instructor")
    public List<Instructor> getAllInstructor(){
        return instructorService.findAllInstructor();
    }

    @GetMapping("/Instructor/{id}")
    public Instructor getInstructor(@PathVariable int id){
        return instructorService.getInstructor(id);
    }

    @GetMapping("/findByInstructorName")
    List<Instructor> findByInstructorName(String instructorName){
        return instructorService.findByInstructorName(instructorName);
    }

    @GetMapping("/findBySalaryIsGreaterThan")
    List<Instructor> findBySalaryIsGreaterThan(int salary) {
        return instructorService.findBySalaryIsGreaterThan(salary);
    }
    @PostMapping("/Instructor")
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorService.saveInstructor(instructor);
    }

    @PutMapping("/Instructor")
    public Instructor uptadeInstructor(@RequestBody Instructor instructor){
        return instructorService.uptadeInstructor(instructor);
    }

    @DeleteMapping("/Instructor/{id}")
    public String deleteInstructor(@PathVariable int id){
        instructorService.deleteInstructor(id);
        return ("Deleted....");
    }

    @DeleteMapping("/deleteByInstructorName")
    public String deleteByInstructorName(@PathVariable String ınstructorName){
        instructorService.deleteByInstructorName(ınstructorName);
        return ("Deleted....");
    }




}
