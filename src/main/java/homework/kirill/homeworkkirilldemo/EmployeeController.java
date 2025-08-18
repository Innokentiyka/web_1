package homework.kirill.homeworkkirilldemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lsatName ){
        return service.addJobs(firstName,lsatName);
    }

    @GetMapping(path="/find")
    public Employee find(@RequestParam("firstName") String firstName , @RequestParam("lastName") String lastName){
        return service.findJobs(firstName,lastName);
    }

    @GetMapping(path = "/all")
    public List<Employee> all(){
        return service.allJobs();
    }

}
