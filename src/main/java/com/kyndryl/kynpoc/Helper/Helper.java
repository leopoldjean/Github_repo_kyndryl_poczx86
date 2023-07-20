package com.kyndryl.kynpoc.Helper;
import com.kyndryl.kynpoc.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

public class Helper {
  
  public static List<Employee> create1MillionUsers(){
    List<Employee> returnArray = new ArrayList<Employee>();    //declaring arraylist
   
    System.out.println("*** Generation of the dataset ***");
    System.out.println("Some examples of employees generated. ");

    for (int i = 0; i < 10; i++) {
      //populate the tempemployee with random datas
    Employee tempEmployee = new Employee();
    //create a name 
    tempEmployee.setLastName(RandomStringUtils.randomAlphabetic(7)); 
    //create an age
    tempEmployee.setFirstName(RandomStringUtils.randomAlphabetic(5));
    // email is hardcoded same for everyone
    tempEmployee.setMail("test@test.com");
    //create a password for each
    tempEmployee.setPassword(RandomStringUtils.randomAlphabetic(10));

    //append new employee in the array
    returnArray.add(tempEmployee);
    // returnArray.add(i, tempEmployee);

    if( i <= 10) System.out.println("Element at index " + i + " : "+ returnArray.get(i) );
    }
    
    return returnArray;
  }


}
