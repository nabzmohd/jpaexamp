package com.javapoint.jpaexamp.api.upload;

public class FileUploadResponse {
	private String fileName;
//	private String downloaduri;
	private Long size;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
//	public String getDownloaduri() {
//		return downloaduri;
//	}
//	public void setDownloaduri(String downloaduri) {
//		this.downloaduri = downloaduri;
//	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
	
}