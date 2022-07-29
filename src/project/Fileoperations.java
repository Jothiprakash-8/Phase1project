package project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import project.Application;

public class Fileoperations {
	static Scanner sn = new Scanner(System.in);
	static String directory = "C://users//ayyaj/P1project";

	public static void fileoperations() {
		System.out.println("");
		System.out.println("Press 1 to Add a file to the existing directory list");
		System.out.println("Press 2 to Delete a user specified file from the existing directory list");
		System.out.println("Press 3 to Search a user specified file from the main directory");
		System.out.println("Press 4 to navigate back to the main context");
		String s1 = sn.nextLine();
		cases(s1);
	}
	
	public static void cases(String s) {
		switch(s) {
			case "1":
				System.out.println("You selected Add Operation");
				add();
				break;
			case "2":
				System.out.println("You selected Delete Operation");
				delete();
				break;
			case "3":
				System.out.println("You selected Search Operation");
				search();
				break;
			case "4":
				System.out.println("Going Back to Main Menu");
				Application.choose();
				break;				
			default:
				System.out.println("Invalid input");
		}
		fileoperations();
	}
	
	
	public static void add() throws InvalidPathException {
		System.out.println("Enter the file path");
		String input = sn.nextLine();
		Path path;
		try {
			path = Paths.get(input);	
		} catch (Exception e) {
			System.out.println("Invalid input");
			return;
		}

		if (!Files.exists(path)) {
			System.out.println("No such file exist");
			return;
		}else {
			System.out.println("File is present");
			
		}
		
		String newPath = directory + "/" + path.getFileName();
		int x = 0;
		while (Files.exists(Paths.get(newPath))) {
			x++;
			newPath = directory + "/" + x + "_" + path.getFileName();
		}
		
		try {
			Files.copy(path,  Paths.get(newPath));
			System.out.println("file has been stored");
		} catch (IOException e) {
			System.out.println("Not able to store the file");
			System.out.println(e);
		}

	}
	

	
	public static void delete() throws InvalidPathException {
		System.out.println("Enter the file path");
		String inputfile = sn.nextLine();
		String Path = directory + "/" + inputfile;
		Path path;
		
		try {
			path = Paths.get(Path);	
		} catch (Exception e) {
			System.out.println("Invalid input");
			return;
		}
		
		if (!Files.exists(path)) {
			System.out.println("File not found");
			return;
		} else {
			System.out.println("File is present");
		}
		
		File Delete = new File(Path);
		try {
			Delete.delete();
			System.out.println("File is deleted");
		} 
		catch (Exception e) {
	
			System.out.println("Not able to delete file");
			System.out.println(e);
		}
	}
	

	
	public static void search() throws InvalidPathException{
		System.out.println("Enter the file to search");	
		String input = sn.nextLine();
		String Path = directory + "/" + input;
		Path path;
		
		try {
			path = Paths.get(Path);	
		} catch (Exception e) {
			System.out.println("Invalid input");
			return;
		}
		
		if(!Files.exists(path)) {
			System.out.println("No such file exist");
			return;
		} else {
			System.out.println("File is present");
		}

	}

}
