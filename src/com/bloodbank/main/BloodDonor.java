package com.bloodbank.main;

import java.util.Date;

public class BloodDonor {
	private String lastName;
	private String firstInitial;
	private String bloodType;
	private String rH;
	private Date dateDonated;

	public BloodDonor(String lastName, String firstInitial, String bloodType, String rH, Date dateDonated) {
		super();
		this.lastName = lastName;
		this.firstInitial = firstInitial;
		this.bloodType = bloodType;
		this.rH = rH;
		this.dateDonated = dateDonated;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstInitial() {
		return firstInitial;
	}

	public void setFirstInitial(String firstInitial) {
		this.firstInitial = firstInitial;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getrH() {
		return rH;
	}

	public void setrH(String rH) {
		this.rH = rH;
	}

	public Date getDateDonated() {
		return dateDonated;
	}

	public void setDateDonated(Date dateDonated) {
		this.dateDonated = dateDonated;
	}
}
