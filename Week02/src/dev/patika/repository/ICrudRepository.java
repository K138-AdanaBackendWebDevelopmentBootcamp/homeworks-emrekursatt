package dev.patika.repository;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.models.Student;

import java.util.List;

//// CRUD --> Create, Read, Update, Delete
public interface ICrudRepository<T> {

    List<T> findAll();
    T findById(int id);
    void saveDatabase(T object);
    void deleteFromDatabase(T object);
    void deleteFromDatabase(int id);
    void uptadeOnDatabese(T object , int id);



}
