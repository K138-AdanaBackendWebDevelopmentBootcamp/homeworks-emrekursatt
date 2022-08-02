package patika.dev.schoolmanagementsystemproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data //@Getter,@Setter,@RequiredArgsConstructor,@ToString,@EqualsAndHashCode *Anatations are included*
@NoArgsConstructor //Constructor builder
@Entity // Indicates It's JPA class
public class VisitingResearcher extends Instructor {
    private double hourSalary;

    public VisitingResearcher(String name, String address, String phoneNumber, double hourSalary) {
        super(name, address, phoneNumber);
        this.hourSalary = hourSalary;
    }




}