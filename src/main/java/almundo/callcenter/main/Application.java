package almundo.callcenter.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import almundo.callcenter.entity.Employee;
import almundo.callcenter.entity.EmployeeRepository;

@SpringBootApplication(scanBasePackages = { "almundo.callcenter" })
@EnableMongoRepositories("almundo.callcenter")
public class Application implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
//    	List<Employee> employees = new ArrayList<>();
//    	employees.add(new Employee("Bruce", "Batman", "idle", "Director"));
//    	employees.add(new Employee("Clark", "Superman", "idle", "Operator"));
//    	employees.add(new Employee("Pato", "Acuaman", "idle", "Operator"));
//    	employees.add(new Employee("Peter", "Spiderman", "idle", "Operator"));
//    	employees.add(new Employee("Tony", "Iron Man", "idle", "Supervisor"));
//    	employees.add(new Employee("Bruce", "Hulk", "idle", "Operator"));
//    	employees.add(new Employee("Juana", "La Iguana", "idle", "Supervisor"));
//    	employees.add(new Employee("Leonardo", "Tortuga Azul", "idle", "Operator"));
//    	employees.add(new Employee("Rafael", "Tortuga Roja", "idle", "Operator"));
//    	employees.add(new Employee("Donatello", "Totuga Morada", "idle", "Operator"));
//    	employees.add(new Employee("Miguel Angel", "Tortuga Naranja", "idle", "Operator"));
//		
//		repository.deleteAll();

		// save a couple of customers

//		repository.saveAll(employees);

		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Customer customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();

		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository.findByFirstName("Pato"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Customer customer : repository.findByLastName("Hulk")) {
//			System.out.println(customer);
//		}
		
	}

}
