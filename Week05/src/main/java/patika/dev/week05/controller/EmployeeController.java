package patika.dev.week05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import patika.dev.week05.model.Employee;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>();

    @PostConstruct
    public void init(){
        Employee employee1 =  Employee.builder().id(1).salary(25000).fullName("Koray").age(38).build();
        Employee employee2 =  Employee.builder().id(2).salary(20000).fullName("Emre").age(27).build();
        Employee employee3 =  Employee.builder().id(3).salary(18000).fullName("Nur").age(28).build();

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

    }
    @GetMapping("/employees")
    public String getAllEmployess(Model theModel){
        theModel.addAttribute("employees", employeeList);
        return "employees";

    }
}
