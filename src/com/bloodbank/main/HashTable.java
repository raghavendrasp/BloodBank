package com.bloodbank.main;

import java.util.ArrayList;

public class HashTable {
	private ArrayList<Profile>[] hashArray;
	private Integer SIZE = null;

	public HashTable(int size) {
		this.SIZE = size;
		hashArray = (ArrayList<Profile>[]) new ArrayList[SIZE];
		for (int i = 0; i < SIZE; i++) {
			hashArray[i] = new ArrayList<Profile>();
		}
	}

	private int computeHash(String s) {
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash += s.charAt(i);
		}
		return (hash % SIZE);
	}

	public Profile searchProfile(Profile profile) {
		int hash = computeHash(profile.getFullName());
		ArrayList<Profile> profileList = hashArray[hash];
		for (Profile profileData : profileList) {
			if (profileData.getFullName().equalsIgnoreCase(profile.getFullName()))
				return profileData;
		}
		return null;
	}

	public void add(Profile profile) {
		int hash = computeHash(profile.getFullName());
		ArrayList<Profile> arrlist = hashArray[hash];
		if (!arrlist.contains(profile)) // Don’t add if duplicate
		{
			arrlist.add(profile);
		}

	}
}
