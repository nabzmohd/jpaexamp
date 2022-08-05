package com.javapoint.jpaexamp.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

//@Document(collation = "car")
public class Car {

//	@Transient
//	public static final String SEQUENCE_NAME = "user_sequence3";
	
	
	@Id
	private Long id;
	@NotBlank(message  ="company required")
	private String company;
	@NotBlank(message  ="carname required")
	private String carname;
	@NotBlank(message  ="carprice required")
	private Integer carprice;
	@NotBlank(message  ="carmodel required")
	private String carmodel;
	private Integer year;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(Long id, @NotBlank(message = "company required") String company,
			@NotBlank(message = "carname required") String carname,
			@NotBlank(message = "carprice required") Integer carprice,
			@NotBlank(message = "carmodel required") String carmodel, Integer year) {
		super();
		this.id = id;
		this.company = company;
		this.carname = carname;
		this.carprice = carprice;
		this.carmodel = carmodel;
		this.year = year;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public Integer getCarprice() {
		return carprice;
	}
	public void setCarprice(Integer carprice) {
		this.carprice = carprice;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", company=" + company + ", carname=" + carname + ", carprice=" + carprice
				+ ", carmodel=" + carmodel + ", year=" + year + "]";
	}
	
	
}
