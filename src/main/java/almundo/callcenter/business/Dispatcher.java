package almundo.callcenter.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import almundo.callcenter.constants.EmplType;
import almundo.callcenter.constants.StatusType;
import almundo.callcenter.datatransfer.InputDTO;
import almundo.callcenter.datatransfer.OutputDTO;
import almundo.callcenter.entity.Employee;
import almundo.callcenter.entity.EmployeeRepository;

@Service
public class Dispatcher extends Thread{
	
	@Autowired
	EmployeeRepository eRepo;
	
	//Maximum thread count is 10
	ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	/**
	 * Main Method who is called from the controller
	 * @param in
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public OutputDTO processCall(InputDTO in) throws InterruptedException, ExecutionException {
		
		//Retrieve all available employees from DB ordered by date of the last call, this with the intention to reduce as possible DB requests
		List<Employee> idleEmpls = getEmplByStatus(StatusType.IDLE.getType());
		
		List<Employee> operators = classifyEmployees(idleEmpls, EmplType.Operator.getType());
		List<Employee> supervisors = classifyEmployees(idleEmpls, EmplType.Supervisor.getType());
		List<Employee> directors = classifyEmployees(idleEmpls, EmplType.Director.getType());
		
		if(!operators.isEmpty()) {
			return dispatchCall(operators, executorService);
		}
		else if(!supervisors.isEmpty()) {
			return dispatchCall(supervisors, executorService);
		}
		else if(!directors.isEmpty()) {
			return dispatchCall(directors, executorService);
		}
		else {
			return new OutputDTO("THERE IS NOT AGENT AVAILABLE AT THIS MOMENT...");
		}
	}
	
	/**
	 * Method for dispatch the current call
	 * @param empls
	 * @param executorService
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private OutputDTO dispatchCall(List<Employee> empls, ExecutorService executorService) throws InterruptedException, ExecutionException {
		empls.get(0).setStatus(StatusType.BUSY.getType());
		eRepo.save(empls.get(0));
		int tLife = calculateECT()*1000;
		
        Callable<String> callable = () -> {
        	System.out.println("CALL IN PROGRESS BY: ".concat(empls.get(0).getFirstName()).concat(" ").concat(empls.get(0).getLastName()).concat(" (").concat(empls.get(0).getType()).concat(") ").concat("ETC ").concat(String.valueOf(tLife)));
            Thread.sleep(tLife);
            return "CALL PROCESSED BY: ".concat(empls.get(0).getFirstName()).concat(" ").concat(empls.get(0).getLastName()).concat(" (").concat(empls.get(0).getType()).concat(")");
        };
		
        Future<String> future = executorService.submit(callable);
        // Future.get() blocks until the result is available
        String result = future.get();
        System.out.println(result);

		empls.get(0).setStatus(StatusType.IDLE.getType());
		eRepo.save(empls.get(0));
		return new OutputDTO(result);
	}
	
	
	//Utility Methods

	/**
	 * Get all idle employees, using repository
	 * @param status
	 * @return
	 */
	private List<Employee> getEmplByStatus(String status){
		return eRepo.findByStatusOrderByDateLastCall(StatusType.IDLE.getType());
	}
	
	
	/**
	 * This method calculates the estimated call time
	 * @return
	 */
	private int calculateECT() {
		Random random =  new Random();
		return (5 + random.nextInt(11 - 5));
	}
	
	/**
	 * This Method all employees of a specific type from a input list, based in the input type param
	 * @param employees
	 * @param type
	 * @return
	 */
	private List<Employee> classifyEmployees(List<Employee> employees, String type){
		List<Employee> out = new ArrayList<>();
		for(Employee e: employees) {
			if(e.getType().equals(type)) {
				out.add(e);
			}
		}
		return out;
	}
}
