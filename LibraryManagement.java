package LibraryManagement;

import java.util.Scanner;
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab6
 * Lab Professor - Dr. Anu Thomas
 */

/**
 * The purpose of this class is to run the program by using all the available classes
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public class LibraryManagement {

	/**
	 * Main method for executing methods
	 * @param args for arguments
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);       //Scanner class called and input object stated
		
		System.out.print("Enter name of the library: ");
		String name = input.nextLine();         //takes input for library name
		
		Library l = new Library(name, input);     //l named object for aggregation
		l.userMenu(input);                 //method called using object
		
	}//end main method
}//exit class