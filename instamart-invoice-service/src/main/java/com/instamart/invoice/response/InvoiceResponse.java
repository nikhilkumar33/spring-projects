package com.instamart.invoice.response;

public class InvoiceResponse 
{
	private int invId;
	private String invValue;
	private String gstNo;
	private String note;
	private String status;
	private String description;
	
	public int getInvId() {
		return invId;
	}
	public void setInvId(int invId) {
		this.invId = invId;
	}
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
