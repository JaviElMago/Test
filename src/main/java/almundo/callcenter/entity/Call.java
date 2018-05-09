package almundo.callcenter.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Call implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private int lifeTime = 0;

	public Call() {
		super();
	}

	public Call(int lifeTime) {
		super();
		this.lifeTime = lifeTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLifeTime() {
		return lifeTime;
	}

	public void setLifeTime(int lifeTime) {
		this.lifeTime = lifeTime;
	}
	
}
