package com.javapoint.jpaexamp.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Book3")
public class Book3 {

	@Transient

	public static final String SEQUENCE_NAME = "user_sequence3";

	@Id
	private Long id;
	@NotBlank(message = "bookname required")
	private String bookName;
	@NotBlank(message = "authername required")
	private String bookPrice;
	@NotBlank(message = "authername required")
	private String authername;
	private Date creationDate;
	public Book3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book3(Long id, @NotBlank(message = "bookname required") String bookName,
			@NotBlank(message = "authername required") String bookPrice,
			@NotBlank(message = "authername required") String authername, Date creationDate) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.authername = authername;
		this.creationDate = creationDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public static String getSequenceName3() {
		return SEQUENCE_NAME;
	}
	@Override
	public String toString() {
		return "Book3 [id=" + id + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", authername=" + authername
				+ ", creationDate=" + creationDate + "]";
	}

}
