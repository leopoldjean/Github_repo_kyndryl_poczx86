package com.kyndryl.kynpoc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kyndryl.kynpoc.model.Employee;
import com.kyndryl.kynpoc.repository.EmployeeRepository;
import com.kyndryl.kynpoc.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("/getEmployees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    
    //Get all employee that have that name queried
    @GetMapping("/getEmployeesByName")
    public List<Employee> getEmployeeByName (@RequestParam String askName) {
        System.out.println("\n**** 'getEmployeeByName Launch with name " + askName.toUpperCase() + "  ****");
         List<Employee> listeEmployees = employeeRepository.findByName(askName);
        return listeEmployees;
    }

    //write 1 million users to db
    @PostMapping("/saveEmployees")
    public String SaveEmployees(){
    return employeeService.saveEmployees();
    }


    // Write only one employee to the DB
    @PostMapping("/saveEmployee")
    public String SaveEmployee(){
      Employee employee = new Employee();
      employee.setFirstName("leo");
      employee.setLastName("urang");
      employee.setMail("coucou@test.com");
      employee.setPassword("password");

      return "employee append : " + employeeService.saveEmployee(employee);
    }
}