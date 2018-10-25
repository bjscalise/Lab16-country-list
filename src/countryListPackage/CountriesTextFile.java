package countryListPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesTextFile {
	
	
	public static void writeToFile(Scanner scan, String directoryFolder, String fileName) {
		
		
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();
		
		try {

			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true)); 
			System.out.println("\n");//True ensures that new data is written on the end instead of overwriting.
			outW.println(scan.nextLine());
			outW.close(); // Mandatory! Make sure that this is closed when you are done.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("The file was not found");
		}
	}
	
	public static void readFromFile(String directoryFolder, String fileName) {
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	
	
	public static void createDirectory() {
		String dirPath = "CountriesFolder";

		Path folder = Paths.get(dirPath);

		if (Files.notExists(folder)) {

			try {
				Files.createDirectories(folder);
				System.out.println("Folder was created successfully!");
			} catch (IOException e) {
				System.out.println("Something went wrong with the folder creation");
				e.printStackTrace();
			}
		}
		
	}
	
	public static void createFile(String directoryFolder, String fileName) {

		Path filePath = Paths.get(directoryFolder, fileName);
		if (Files.notExists(filePath)) {

			try {
				Files.createFile(filePath);
				System.out.println("File was created successfully!");
			} catch (IOException e) {
				System.out.println("Something wnet wrong with the file creation.");
				e.printStackTrace();
			}
		}
	}
	
}
