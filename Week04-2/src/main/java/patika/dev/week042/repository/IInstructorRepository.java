package patika.dev.week042.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.week042.models.Instructor;

@Repository
public interface IInstructorRepository extends JpaRepository<Instructor , Integer> {
}
