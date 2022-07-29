package com.javapoint.jpaexamp.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class Book {
	


	@Id
//	@Generated(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	@NotBlank(message ="bookname required")
	private String bookName;
	@NotBlank(message ="authername required")
	private String bookPrice;
	@NotBlank(message ="authername required")
	private String authername;
	private Date creationDate = new Date();
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, @NotBlank(message = "bookname required") String bookName,
			@NotBlank(message = "authername required") String bookPrice,
			@NotBlank(message = "authername required") String authername, Date creationDate) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.authername = authername;
		this.creationDate = creationDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getAuthername() {
		return authername;
	}
	public void setAuthername(String authername) {
		this.authername = authername;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", authername=" + authername
				+ ", creationDate=" + creationDate + "]";
	}
	

}
