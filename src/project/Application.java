package project;

import java.util.Scanner;
import project.Orderfile;
import project.Fileoperations;

public class Application {
	static Scanner sn = new Scanner(System.in);

	public static void display() {
		System.out.println("Project:LockedMe.com");
		System.out.println("Developed by Ayya Jothi Prakash");
		System.out.println("Description: Application to add, delete, and search files");
	}
	public static void choose() {
		System.out.println("");
		System.out.println("Main Menu");
		System.out.println("Press 1 to Retrieving the file names in an ascending order");
		System.out.println("Press 2 to Perform business level operations");
		System.out.println("Press 3 to Close the application");

		int choice = sn.nextInt();
		cases(choice);
	}
	public static void cases(int a) {
		switch(a) {
			case 1:
				Orderfile.sort();
				break;
			case 2:
				Fileoperations.fileoperations();
				break;
			case 3:
				System.out.println("Exit");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
		}
		choose();
	}

	public static void main(String[] args) {
		display();
		choose();
		

	}

}
