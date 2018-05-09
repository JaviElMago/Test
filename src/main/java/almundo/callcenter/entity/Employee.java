package almundo.callcenter.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * This is the representation of the entity employee
 * @author hflores
 *
 */
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	private String status;
	private String type;
	private Date dateLastCall;
	
	public Employee() {}
	
	public Employee(String firstName, String lastName, String status, String type, Date dateLastCall) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.type = type;
		this.dateLastCall = dateLastCall;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateLastCall() {
		return dateLastCall;
	}

	public void setDateLastCall(Date dateLastCall) {
		this.dateLastCall = dateLastCall;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", status=" + status
				+ ", type=" + type + ", dateLastCall="+dateLastCall+"]";
	}

}
