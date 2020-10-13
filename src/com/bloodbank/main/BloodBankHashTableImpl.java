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
		if (fileName != null) {
			System.out.println("Enter valid filepath");

			CsvReadUtility csvReadUtility = new CsvReadUtility();
			try {
				HashTable hashTable = csvReadUtility.readCsvIntoHashTable(fileName);
				if(hashTable.profileList.isEmpty()) {
					System.out.println("Empty File");
				}else {
					System.out.println("Enter option");
					System.out.println("1. Remove old");
					System.out.println("2. newest of type");
					System.out.println("3. Count by Type");
					System.out.println("4. print donor records");
					System.out.println("5. add");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
