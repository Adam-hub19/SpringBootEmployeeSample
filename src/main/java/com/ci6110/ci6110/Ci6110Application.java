package com.ci6110.ci6110;

import com.ci6110.ci6110.entities.Employee;
import com.ci6110.ci6110.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//public class Ci6110Application implements CommandLineRunner {
public class Ci6110Application{

    
   @Autowired
    private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ci6110Application.class, args);
	}
        
        
  // @Override
    //   public void run(String... args) throws Exception {
        @Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
            employeeRepository.save(new Employee("jack", "jade", (float) 40.4));
            employeeRepository.save(new Employee("amy", "harrison", (float) 10023.32));
            employeeRepository.save(new Employee("hellen", "finn", (float) 423323.44));
            employeeRepository.save(new Employee("jack", "jade", (float) 40.4));
            employeeRepository.save(new Employee("amy", "harrison", (float) 10023.32));
            employeeRepository.save(new Employee("hellen", "finn", (float) 423323.44));
            employeeRepository.save(new Employee("jack", "jade", (float) 40.4));
            employeeRepository.save(new Employee("amy", "harrison", (float) 10023.32));
            employeeRepository.save(new Employee("hellen", "finn", (float) 423323.44));
            employeeRepository.save(new Employee("jack", "jade", (float) 40.4));
          
                };  
            
}      
         
}
