package com.javapoint.jpaexamp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class userRecord {
	@NotNull
	private Integer id;
	@NotBlank(message ="name required")
	private String name;
	@NotBlank(message = "email required")
	private String email;
	
	public userRecord() {
		super();
	}

	

	public userRecord(@NotNull Integer id, @NotBlank(message = "name required") String name,
			@NotBlank(message = "email required") String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "userRecord [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	public static char[] next() {
	// TODO Auto-generated method stub
	return null;
}
	
	
}
	
	
	
	
	
	
	
	
