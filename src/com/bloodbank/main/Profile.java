/**
 * 
 */
package com.bloodbank.main;

import java.util.Date;

/**
 * @author
 *
 */
public class Profile {
	String firstName;
	String lastName;
	String bloodType;
	String rh;
	Date donatedDate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public Date getDonatedDate() {
		return donatedDate;
	}

	public void setDonatedDate(Date donatedDate) {
		this.donatedDate = donatedDate;
	}

}