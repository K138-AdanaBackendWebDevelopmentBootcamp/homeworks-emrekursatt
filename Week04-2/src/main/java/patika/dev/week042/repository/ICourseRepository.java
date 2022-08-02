package patika.dev.week042.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import patika.dev.week042.models.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

    @Query("from Course c WHERE id=?1")
    Course findCourse(int id);


    /* Course findCourseByCode(int creditScore);*/
}


