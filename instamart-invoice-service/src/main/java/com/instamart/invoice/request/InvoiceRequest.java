package com.instamart.invoice.request;

public class InvoiceRequest 
{
	private String invValue;
	private String gstNo;
	private String note;
	private String status;
	private String description;
	
	public String getInvValue() {
		return invValue;
	}
	public void setInvValue(String invValue) {
		this.invValue = invValue;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
