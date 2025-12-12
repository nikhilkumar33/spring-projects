package com.instamart.invoice.request;

public class UpdateRequest 
{
	private int invId;
	private String invValue;
	private String gstNo;
	private String note;
	private String status;
	private String description;
	private String activeStatus;
	
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
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
}
