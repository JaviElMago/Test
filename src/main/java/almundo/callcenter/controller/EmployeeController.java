package almundo.callcenter.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import almundo.callcenter.entity.Employee;
import almundo.callcenter.entity.EmployeeRepository;

/**
 * Test Controller, this is very use full to modify the base DB data
 * @author hflores
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	/**
	 * Use this method to initialize the DB, with some test data.
	 * @return
	 */
    @RequestMapping("/reset")
    public List<Employee> init() {
    	repo.deleteAll();
    	List<Employee> employees = new ArrayList<>();
    	Calendar cal = Calendar.getInstance();
    	cal.set(2018, 5, 8, 23, 30, 00);
    	employees.add(new Employee("Bruce Wayne", "Batman", "idle", "Director", cal.getTime()));
    	cal.set(2018, 5, 8, 23, 23, 00);
    	employees.add(new Employee("Clark Kent", "Superman", "idle", "Supervisor", cal.getTime()));
    	cal.set(2018, 5, 8, 23, 23, 30);
    	employees.add(new Employee("Tony Strak", "Iron Man", "idle", "Operator", cal.getTime()));
    	cal.set(2018, 5, 8, 23, 25, 00);
    	employees.add(new Employee("Peter Parker", "Spiderman", "idle", "Operator", cal.getTime()));
    	repo.saveAll(employees);
        return repo.findAll();
    }

}
