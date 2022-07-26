package dev.patika.controller;


import dev.patika.models.Student;
import dev.patika.service.StudentService;

import java.util.List;

public class StudentController  {

    private static StudentService studentService = new StudentService();


    public List<Student> findAllStudent(){
        return studentService.findAll();

    }
    public Student findStudentById(int id){

        return studentService.findById(id);
    }

    public static void saveStudent(Student student){
        studentService.saveDatabase(student);

    }
}
