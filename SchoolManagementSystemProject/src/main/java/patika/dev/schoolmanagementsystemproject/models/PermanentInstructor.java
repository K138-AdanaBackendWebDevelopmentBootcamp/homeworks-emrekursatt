package patika.dev.schoolmanagementsystemproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data //@Getter,@Setter,@RequiredArgsConstructor,@ToString,@EqualsAndHashCode *Anatations are included*
@NoArgsConstructor //C onstructor builder
@Entity // Indicates It's JPA class

public class PermanentInstructor extends Instructor {
    private double fixedSalary;


    public PermanentInstructor(String name, String address, String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }
}