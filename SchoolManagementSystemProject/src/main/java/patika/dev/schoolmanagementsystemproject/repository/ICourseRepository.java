package patika.dev.schoolmanagementsystemproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import patika.dev.schoolmanagementsystemproject.models.Course;

import java.util.List;

@Repository // Persistance to indicate that the class is
public interface ICourseRepository extends CrudRepository<Course,Integer> {


    List<Course> findByCourseName(String courseName);

    List<Course> findByCreditScoreIsGreaterThan(int creditScore);
    List<Course> findTopByCreditScoreIsGreaterThan(int creditScore);

    void deleteByCourseName(String courseName);





}
