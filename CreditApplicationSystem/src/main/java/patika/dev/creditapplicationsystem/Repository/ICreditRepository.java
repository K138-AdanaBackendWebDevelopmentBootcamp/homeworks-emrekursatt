package patika.dev.creditapplicationsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.creditapplicationsystem.Models.Credit;

@Repository
public interface ICreditRepository extends JpaRepository<Credit,Long> {
}
