package com.kyndryl.kynpoc.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyndryl.kynpoc.KynpocApplication;
import com.kyndryl.kynpoc.model.Employee;
import com.kyndryl.kynpoc.repository.EmployeeRepository;

import lombok.Data;

interface EmployeeServiceInt {
  public Optional<Employee> getEmployeeById(final Long id);
  public Iterable<Employee> getEmployees() ;
  public void deleteEmployee(final Long id);
  public Employee saveEmployee(Employee employee);
  String saveEmployees();
}

@Data
@Service
public class EmployeeService implements EmployeeServiceInt{

    @Autowired
    private static EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(final Long id) {
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    public String saveEmployees() {
      List<Employee> employeeArray = KynpocApplication.getEmployeeArray();
      System.out.println("*** Start Uploading Employees in the DB ***");
      employeeRepository.saveAll(employeeArray);
      System.out.println("End of uploading \" + employeeArray.size() + \" employees in the DB.");
      return "End of uploading " + employeeArray.size() + " employees in the DB.";
    }

}