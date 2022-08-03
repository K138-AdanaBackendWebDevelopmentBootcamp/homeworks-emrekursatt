package patika.dev.schoolmanagementsystemproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patika.dev.schoolmanagementsystemproject.models.Instructor;
import patika.dev.schoolmanagementsystemproject.models.Student;
import patika.dev.schoolmanagementsystemproject.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    @Autowired //Thanks to the Spring framework IoC, it can be used with different binding methods (such as @Autowired, constructor)
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }


    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping("/students")
    public Student uptadeStudent(@RequestBody Student student){
        return studentService.uptadeStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ("Deleted....");
    }

    @DeleteMapping("/deleteByStudentsName")
    public String deleteByStudentName(@PathVariable String studentName){
        studentService.deleteByStudentName(studentName);
        return ("Deleted....");
    }
}
