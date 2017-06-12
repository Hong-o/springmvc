package com.hejie.entity;

public class PhoneNumber {
	//029-88888888
	
	private String areaCode;//区号
	
	private String phone;//电话号码

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "StringToPhoneNumber [areaCode=" + areaCode + ", phone=" + phone + "]";
	}
	
	
}
