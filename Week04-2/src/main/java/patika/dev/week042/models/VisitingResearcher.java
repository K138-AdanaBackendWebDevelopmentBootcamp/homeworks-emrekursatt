package patika.dev.week042.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class VisitingResearcher extends Instructor {
    private double hourSalary;

    public VisitingResearcher(String name, String address, String phoneNumber, double hourSalary) {
        super(name, address, phoneNumber);
        this.hourSalary = hourSalary;
    }




}