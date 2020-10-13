/**
 * 
 */
package com.bloodbank.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 *
 */
public class CsvReadUtility {
	private static final String COMMA_DELIMITER = ",";

	public List<Profile> readCsvIntoList(String inputFile) {
		String line;
		BufferedReader br = null;
		List<Profile> profileList = null;
		try {
			br = new BufferedReader(new FileReader(inputFile));
			profileList = new ArrayList<Profile>();
			br.readLine(); // skip headers
			while ((line = br.readLine()) != null) {
				Profile profile = new Profile();
				String[] values = line.split(COMMA_DELIMITER);
				if(values.length != 5) {
					throw new RuntimeException("Header Count Mismatch");
				}
				profile.setLastName(values[0]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return profileList;
	}

	public void writeToCsv(List<Profile> profileList) {

	}
}
