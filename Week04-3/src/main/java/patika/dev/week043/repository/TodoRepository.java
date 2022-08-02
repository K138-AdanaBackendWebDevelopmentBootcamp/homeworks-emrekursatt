package patika.dev.week043.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import patika.dev.week043.model.Todo;

@Repository
public interface TodoRepository  extends CrudRepository<Todo,Integer> {
}
