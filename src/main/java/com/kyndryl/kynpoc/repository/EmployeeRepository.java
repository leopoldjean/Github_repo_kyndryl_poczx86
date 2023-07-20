package com.kyndryl.kynpoc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kyndryl.kynpoc.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

 @Query(value = "SELECT * FROM employees e WHERE e.name = :askName", nativeQuery = true)
List<Employee> findByName(@Param("askName") String askName);
  


}