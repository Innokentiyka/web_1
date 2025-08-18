package homework.kirill.homeworkkirilldemo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService  {

    private final int maxJobs = 5;
    private List<Employee> jobsList = new ArrayList<>();


    public String addJobs (String firstName, String lastName){
        for (int i = 0; i < jobsList.size(); i++) {
            if (jobsList.get(i).equals(new Employee(firstName,lastName))){
                throw new EmployeeAlreadyAddedException();
            }
        }
        if (maxJobs > jobsList.size()){
            jobsList.add(new Employee(firstName,lastName));
            return "Сотрудник добавлен";
        }else{
            throw new EmployeeStorageIsFullException();
        }
    }

    public String removeJobs (String firstName,String lastName){

        for (int i = 0; i < jobsList.size(); i++) {
            if (jobsList.get(i).equals(new Employee(firstName,lastName))){
                jobsList.remove((Employee) new Employee(firstName,lastName));
                return "Сотрудник удален";
            }
        }
        throw new EmployeeNotFoundException();
    }


    public Employee findJobs (String firstName, String lastName){

        for (int i = 0; i < jobsList.size(); i++) {
            if (jobsList.get(i).equals(new Employee(firstName,lastName))){
                return jobsList.get(i);
            }
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> allJobs (){
        return List.copyOf(jobsList);
    }
}
