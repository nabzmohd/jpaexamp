package com.javapoint.jpaexamp.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String detais;
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(Date timestamp, String message, String detais) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detais = detais;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetais() {
		return detais;
	}
	public void setDetais(String detais) {
		this.detais = detais;
	}
	@Override
	public String toString() {
		return "ErrorDetails [message=" + message + ", detais=" + detais + "]";
	}
	
	

}
