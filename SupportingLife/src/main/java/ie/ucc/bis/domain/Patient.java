package ie.ucc.bis.domain;

public class Patient {

	private String name;
	
	public Patient() {
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Patient(String name) {
		this.setName(name);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
