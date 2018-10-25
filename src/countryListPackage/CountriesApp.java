package countryListPackage;

import java.util.Scanner;

public class CountriesApp {
	
	public static void main(String[] args) {
		
		String directoryFolder = "countriesFolder";
		String fileName = "countries.txt";
		
		CountriesTextFile.createDirectory();
		CountriesTextFile.createFile(directoryFolder, fileName);
		
		
		System.out.println("Welcome to the Countries Maintenance Application");
		
		Scanner scan = new Scanner(System.in);
		
		String contPrompt = "Y";
		
		while (contPrompt.equals("Y")) {
		
		String userChoice = Validator.getString(scan, "\nPlease select from the follow list: \n1 - See country List "
				+ "\n2 - Add a country \n3 - Quit program \n");
		
		switch (userChoice) {
			case "1": 
				CountriesTextFile.readFromFile(directoryFolder, fileName);
				break;
			case "2":
				System.out.println("Please enter a country");
				CountriesTextFile.writeToFile(scan, directoryFolder, fileName);
				CountriesTextFile.readFromFile(directoryFolder, fileName);
				break;
			case "3":
				System.out.println("Goodbye");
				System.exit(0);
			default:
				System.out.println("Please enter a valid number");
				}
	
		 while (!contPrompt.equalsIgnoreCase("Y") || contPrompt.equalsIgnoreCase("N")) {
			System.out.println("Please enter a valid #");
			contPrompt = Validator.getString(scan, "Would you like to continue?");
		}
		
		
	
		
		}	
	}
}
	

