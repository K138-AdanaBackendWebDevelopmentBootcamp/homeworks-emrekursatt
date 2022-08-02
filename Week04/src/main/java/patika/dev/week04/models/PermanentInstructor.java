package patika.dev.week04.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;
@Data
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor {
    private double fixedSalary;

    public PermanentInstructor(String name, String address, String phoneNumber, double fixedSalary) {

        this.fixedSalary = fixedSalary;
    }

}