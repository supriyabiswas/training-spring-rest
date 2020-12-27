package com.supriyabiswas.tsr.persistance.model;

public class Address1 {
	private String address1;
	private String address2;
	private String pinNo;
	
	public Address1(String address1,String address2, String pinNo){
	//	super();
		this.address1=address1;
		this.address2=address2;
		this.pinNo=pinNo;
	}
	

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}
	
}

