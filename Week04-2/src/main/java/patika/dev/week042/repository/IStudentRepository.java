package patika.dev.week042.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.week042.models.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
