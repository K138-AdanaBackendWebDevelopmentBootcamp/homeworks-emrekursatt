package patika.dev.schoolmanagementsystemproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import patika.dev.schoolmanagementsystemproject.models.Instructor;

import java.util.List;

@Repository // Persistance to indicate that the class is
public interface IInstructorRepository extends CrudRepository<Instructor,Integer> {

    List<Instructor> findByInstructorName(String instructorName);

    List<Instructor> findBySalaryIsGreaterThan(int salary);

    void deleteByInstructorName(String instructorName);

}


