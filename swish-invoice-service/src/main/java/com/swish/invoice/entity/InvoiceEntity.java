package com.swish.invoice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")

@NamedQuery(name ="filterByStatusAndValue", 
query = "from InvoiceEntity where status = :status and invValue < :invValue")
@NamedQuery(name = "InvoiceEntity.filterByStatus", query = "from InvoiceEntity where status = :status" )

public class InvoiceEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invId;
	private int invValue;
	private String gstNo;
	private String status;
	private String note;
	private String description;
	private String activeStatus = "A";
	
	public int getInvId() {
		return invId;
	}
	public void setInvId(int invId) {
		this.invId = invId;
	}
	public int getInvValue() {
		return invValue;
	}
	public void setInvValue(int invValue) {
		this.invValue = invValue;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
