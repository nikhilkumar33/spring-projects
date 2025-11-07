package com.kodewala.spring_core_bean_java_proj2.bean;

public class FamilyStar {
	
	private String fatherName;
	private String motherName;
	private String childName;
	public FamilyStar(String fatherName, String motherName, String childName) {
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.childName = childName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	@Override
	public String toString() {
		return "FamilyStar [fatherName=" + fatherName + ", motherName=" + motherName + ", childName=" + childName + "]";
	}
	

}
