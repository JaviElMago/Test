package almundo.callcenter.datatransfer;

import java.io.Serializable;

/**
 * DTO for call output, it was created having in mind that possibly the output would require to define son attributes, at this case those must to being define here
 * @author hflores
 *
 */
public class OutputDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg;

	public OutputDTO() {
		super();
	}

	public OutputDTO(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
