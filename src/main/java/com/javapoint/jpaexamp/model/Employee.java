package com.javapoint.jpaexamp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Employee")
public class Employee {
	@Transient
	
	public static final String SEQUENCE_NAME   = "user_sequence";

	@Id
	private long id;
	
	@NotBlank
	@Size(max=100)
	@Indexed(unique = true)
	private String firstName;
	private String lastName;
	
	
	@NotBlank
	@Size(max=100)
	@Indexed(unique= true)
	private String emailId;


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(long id, @NotBlank @Size(max = 100) String firstName, String lastName,
			@NotBlank @Size(max = 100) String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}


	
	
	
}
