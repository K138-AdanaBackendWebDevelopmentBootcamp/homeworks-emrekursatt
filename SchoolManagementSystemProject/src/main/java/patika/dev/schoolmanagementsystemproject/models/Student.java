package patika.dev.schoolmanagementsystemproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data //@Getter,@Setter,@RequiredArgsConstructor,@ToString,@EqualsAndHashCode *Anatations are included*
@NoArgsConstructor //Constructor builder
@Entity // Indicates It's JPA class

public class Student {
    @Id // Indicates It's a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Specifies that the primary key will be automatically generated.
    private int id;
    private String name;
    private String address;
    private String gender;
    private LocalDate birthdate;


    @ManyToMany
    private List <Course> courseList = new ArrayList<>();

    public List <Course> getCourseList(Course course1) {

        return courseList;
    }
    public Student(String name, String address, String gender, LocalDate birthdate) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
    }



}