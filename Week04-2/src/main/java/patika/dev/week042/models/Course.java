package patika.dev.week042.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;

    private String courseCode;

    private int creditScore;
    @JsonBackReference
    @ManyToMany(mappedBy = "courseList"  /*cascade = CascadeType.ALL Bu entityde yapılan değişiklikeri baağlı olduğu entitiylerede uygular*/ )
    private List<Student> studentList = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    private Instructor instructor;

    public Course(String courseName, String courseCode, int creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
        this.studentList = studentList;

    }
}
