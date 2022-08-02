package patika.dev.schoolmanagementsystemproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data //@Getter,@Setter,@RequiredArgsConstructor,@ToString,@EqualsAndHashCode *Anatations are included*
@NoArgsConstructor //C onstructor builder
@Entity // Indicates It's JPA class
@Inheritance (strategy = InheritanceType.JOINED) //To define the top class


public class Instructor {
    @Id // Indicates It's a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Specifies that the primary key will be automatically generated.
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    @JsonManagedReference //@OneToMany to the side @JsonManagedReference
    @OneToMany(mappedBy = "instructor")
    private List <Course> courseList = new ArrayList<>();


    public Instructor(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


}