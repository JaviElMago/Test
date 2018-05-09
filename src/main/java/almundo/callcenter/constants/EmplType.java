package almundo.callcenter.constants;

/**
 * Enum useful to handling charge of the employees
 * @author hflores
 *
 */
public enum EmplType { 
	
    Operator("operator"), 
    Supervisor("supervisor"),
    Director("director");

	private EmplType(String type) {
		
	}
	
	public String getType() {
		return this.getType();
	}
}