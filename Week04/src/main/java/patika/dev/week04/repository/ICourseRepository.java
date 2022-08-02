package patika.dev.week04.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import patika.dev.week04.models.Course;

import java.util.List;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Integer> {

    @Query("select count(e) from Course e ")//Tüm course sayısını bulmak için.
    public int getNumberofCourse();

    @Query(" select c.creditScore , count (c.creditScore) from Course c GROUP BY c.creditScore")// yaşa göre sıralama işlemi
    List<?> getAgeWithGroupİng();


    //method driven query

    List<Course> findByCourseName(String courseName);
    List<Course> findByCourseNameContaining(String str);
    List<Course> findByCreditScoreIsGreaterThan(int creditScore);
    List<Course> findTopByCreditScoreIsGreaterThan(int creditScore);

    void deleteByCourseName(String courseName);
}
