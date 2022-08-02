package patika.dev.week043.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import patika.dev.week043.model.Todo;
import patika.dev.week043.repository.TodoRepository;

import java.time.LocalDateTime;

@RestController
public class TodoController {
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public Todo getJsonFromRemoteTodoList(@PathVariable int id) {

       Todo todo =  restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + id,Todo.class);
        todo.setLocalDateTime(LocalDateTime.now());
        todoRepository.save(todo);
       return todo;
    }
    @GetMapping("/getstr/{id}")
    public ResponseEntity<String> getJsonFromRemoteTodoListWithString(@PathVariable int id) {
       ResponseEntity<String> todoStr = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/" + id , String.class);
        return todoStr;
    }
}
