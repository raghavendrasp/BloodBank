package com.bloodbank.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HashTable {
	LinkedList<DonorProfile> profileList = new LinkedList<DonorProfile>();

	public HashTable(LinkedList<DonorProfile> profileList) {
		this.profileList = profileList;
	}

	public DonorProfile searchProfile(DonorProfile profile) {
		for (DonorProfile profileData : profileList) {
			if (profileData.getFullName().equalsIgnoreCase(profile.getFullName()))
				return profileData;
		}
		return null;
	}

	public void add(DonorProfile profile) {
		if (searchProfile(profile) == null) // Don’t add if duplicate
		{
			profileList.addLast(profile);
		}

	}

	public void removeOld(String inputDateStr) throws ParseException {
		Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDateStr);
		for (DonorProfile profileData : profileList) {
			if (inputDate.after((profileData.getDonatedDate()))) {
				profileList.remove(profileData);
			}
		}
	}

	public DonorProfile newestOfType(String bloodType, String rh) {
		Date latestDate = null;
		DonorProfile latestProfileData = null;
		for (DonorProfile profileData : profileList) {
			if (latestDate == null) {
				latestDate = profileData.getDonatedDate();
			} else if (latestDate.before((profileData.getDonatedDate()))) {
				latestDate = profileData.getDonatedDate();
				latestProfileData = profileData;
			}
		}
		return latestProfileData;
	}

	public Map<String, Integer> countByTypes(String bloodType) {
		Map<String, Integer> countByType = new HashMap<String, Integer>();
		for (DonorProfile profileData : profileList) {
			if (countByType.containsKey(profileData.getBloodType())) {
				countByType.put(profileData.getBloodType(), countByType.get(profileData.getBloodType()) + 1);
			}else {
				countByType.put(profileData.getBloodType(), 1);
			}
		}
		return countByType;
	}
}
