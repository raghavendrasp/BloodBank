/**
 * 
 */
package com.bloodbank.main;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author 
 *
 */
public class BloodBankHashTableImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter file path to read");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		if (fileName == null) {
			System.out.println("Enter valid filepath");
		}
		CsvReadUtility csvReadUtility = new CsvReadUtility();
		try {
			csvReadUtility.readCsvIntoList(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
