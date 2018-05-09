package almundo.callcenter.entity;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mongodb.connection.Stream;

/**
 * Interface to interact with the employee document in the DB
 * @author hflores
 *
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public Employee findByFirstName(String firstName);
    
    public List<Employee> findByLastName(String lastName);
    
    public List<Employee> findByStatus(String status);
    
    public List<Employee> findByStatusOrderByDateLastCall(String status);
 
    public List<Employee> findByStatusAndTypeOrderByDateLastCall(String status, String type);

}
