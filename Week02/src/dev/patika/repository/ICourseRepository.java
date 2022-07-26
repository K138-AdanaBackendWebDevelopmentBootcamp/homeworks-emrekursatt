package dev.patika.repository;

import dev.patika.models.Course;
import dev.patika.models.Student;

import java.util.List;

public interface ICourseRepository {

    void deleteCourseWtihId(int id);

    List<Student> getCourseStudentList(Course course);
}
