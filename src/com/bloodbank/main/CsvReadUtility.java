/**
 * 
 */
package com.bloodbank.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 *
 */
public class CsvReadUtility {
	private static final String COMMA_DELIMITER = ",";

	public List<DonorProfile> readCsvIntoList(String inputFile) throws FileNotFoundException {
		String line;
		BufferedReader br = null;
		List<DonorProfile> profileList = null;
		try {
			br = new BufferedReader(new FileReader(inputFile));
			profileList = new ArrayList<DonorProfile>();
			br.readLine(); // skip headers
			while ((line = br.readLine()) != null) {
				DonorProfile profile = new DonorProfile();
				String[] values = line.split(COMMA_DELIMITER);
				if (values.length != 5) {
					throw new RuntimeException("Header Count Mismatch");
				}
				profile.setLastName(values[0]);
				profile.setFirstName(values[1]);
				profile.setBloodType(values[2]);
				profile.setRh(values[3]);
				if (values[4] != null && values[4] != "") {
					Date donatedDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[4]);
					profile.setDonatedDate(donatedDate);
				}

			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not found");
		} catch (IOException e) {
			throw new RuntimeException("unable to read file");
		} catch (RuntimeException e) {
			throw e;
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse Date");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("error while closing file " + e.getMessage());
				}
			}
		}
		return profileList;
	}

	public void writeToCsv(List<DonorProfile> profileList) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("profile.csv"), "UTF-8"));
			for (DonorProfile profile : profileList) {
				StringBuffer oneLine = new StringBuffer();
				oneLine.append(profile.getLastName());
				oneLine.append(COMMA_DELIMITER);
				oneLine.append(profile.getFirstName());
				oneLine.append(COMMA_DELIMITER);
				oneLine.append(profile.getBloodType());
				oneLine.append(COMMA_DELIMITER);
				oneLine.append(profile.getRh());
				oneLine.append(COMMA_DELIMITER);
				oneLine.append(new SimpleDateFormat("dd/MM/yyyy").format(profile.getDonatedDate()));
				bw.write(oneLine.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (UnsupportedEncodingException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public HashTable readCsvIntoHashTable(String inputFile) throws FileNotFoundException {
		String line;
		BufferedReader br = null;
		HashTable hashTable = new HashTable();
		try {
			br = new BufferedReader(new FileReader(inputFile));
			br.readLine(); // skip headers
			while ((line = br.readLine()) != null) {
				DonorProfile profile = new DonorProfile();
				String[] values = line.split(COMMA_DELIMITER);
				if (values.length != 5) {
					throw new RuntimeException("Header Count Mismatch");
				}
				profile.setLastName(values[0]);
				profile.setFirstName(values[1]);
				profile.setBloodType(values[2]);
				profile.setRh(values[3]);
				if (values[4] != null && values[4] != "") {
					Date donatedDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[4]);
					profile.setDonatedDate(donatedDate);
				}
				hashTable.add(profile);

			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not found");
		} catch (IOException e) {
			throw new RuntimeException("unable to read file");
		} catch (RuntimeException e) {
			throw e;
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse Date");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("error while closing file " + e.getMessage());
				}
			}
		}
		return hashTable;
	}
}
