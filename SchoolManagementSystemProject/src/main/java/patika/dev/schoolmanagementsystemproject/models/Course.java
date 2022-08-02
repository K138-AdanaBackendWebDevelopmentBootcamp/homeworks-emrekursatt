package patika.dev.schoolmanagementsystemproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data //@Getter,@Setter,@RequiredArgsConstructor,@ToString,@EqualsAndHashCode *Anatations are included*
@NoArgsConstructor //C onstructor builder
@Entity // Indicates It's JPA class
public class Course {
    @Id // Indicates It's a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Specifies that the primary key will be automatically generated.
    private int id;


    private String courseName;

    private String courseCode;

    private int creditScore;

    @JsonBackReference //Bidirectionally generate JSON structure *(@OneToMany to the side @JsonManagedReference)*
    @ManyToMany(mappedBy = "courseList"  )
    private List<Student> studentList = new ArrayList<>();


    @JsonBackReference //Bidirectionally generate JSON structure *(@OneToMany to the side @JsonManagedReference)*
    @ManyToOne
    private Instructor instructor;

    public Course(String courseName, String courseCode, int creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
        this.studentList = studentList;

    }
}
