package patika.dev.week04.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;
@Data
@NoArgsConstructor
@Entity
public class VisitingResearcher extends Instructor {
    private double hourSalary;

    public VisitingResearcher(String name, String address, String phoneNumber, double hourSalary) {
        this.hourSalary = hourSalary;
    }




}