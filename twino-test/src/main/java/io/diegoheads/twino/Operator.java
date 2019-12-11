package io.diegoheads.twino;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Operator {
	
	@Id
	private String username;
	private String firstName;
	private String lastName;
	private String passwd;
	
	public Operator() {
		
	}
	
	public Operator(String username, String firstName, String lastName, String passwd) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwd = passwd;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	

}
