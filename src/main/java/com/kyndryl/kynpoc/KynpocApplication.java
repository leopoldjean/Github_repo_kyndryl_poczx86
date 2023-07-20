package com.kyndryl.kynpoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.kyndryl.kynpoc.Helper.Helper;
import com.kyndryl.kynpoc.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories("com.*")
@ComponentScan(basePackages = "com.kyndryl.kynpoc.*")
@EntityScan("com.kyndryl.kynpoc.model") 
public class KynpocApplication implements CommandLineRunner {

  private static List<Employee> randomEmployeesArray = new ArrayList<Employee>();

	public static void main(String... args) {
		SpringApplication.run(KynpocApplication.class, args);
	}

  //fct executed during start up of the program.
  @Override
  public void run (String... args) throws Exception {
      System.out.println("Hello World!");
      setEmployeeArray();
      System.out.println("\n*** End of generation ***\n");  
  }

  private static void setEmployeeArray() {
    randomEmployeesArray = Helper.create1MillionUsers();
  }

  public static List<Employee> getEmployeeArray() {
      return randomEmployeesArray;
  }

}
