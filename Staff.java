package LibraryManagement;

import java.io.Serializable;
import java.util.Scanner;
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab6
 * Lab Professor - Dr. Anu Thomas
 */

/**
 * The purpose of this class is to create a user of type Staff
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public class Staff extends User implements Serializable {

	/**Long variable for serializable class*/
	private static final long serialVersionUID = 1L;
	/** Age of the staff member */
	protected int age;// Age of the staff member
	/** Floor number registered to the staff member **/
	protected int floorNum;// Floor number registered to the staff member
	/** Section registered to the staff member */
	protected char section;// Section registered to the staff member

	/**No-arg constructor with same name as class name*/
	Staff() {    //no-arg constructor
		super.type = "Staff";
	}

	/**
	 * Parameterized constructor
	 * @param age for storing age of staff user
	 * @param floorNum for storing details of floor number where staff user work
	 * @param section for storing section details in which the staff user works
	 */
	Staff(int age, int floorNum, char section) {  //parameterized constructor
		super();                     //call parent class constructor
		this.age = age;             //implicitly states variables
		super.type = "Staff";       //explicitly states type of user
		this.floorNum = floorNum;   //implicitly states variables
		this.section = section;     //implicitly states variables
	}

	/**
	 * Override method for reading person details
	 */
	@Override
	public void readPerson(Scanner input) {
		boolean control = true;         //boolean type local variable
		do { // allows the user to re-enter details
			try {
				super.readPerson(input);       //parent method call explicitly
				boolean control2 = true;       //boolean type local variable
				boolean idCheck = true;        //boolean type local variable
				int tempId = 0;                //local variable for storing temporary id of staff
				do {
					System.out.print("Enter Staff Id: ");
					tempId = input.nextInt();

					for (int i = 0; i < Library.users.size(); i++) {
						if ((tempId == Library.users.get(i).getId()) && Library.users.get(i).type.equals("Staff")) {
							idCheck = false;                 //end boolean 
							i = Library.users.size();        //local variable for storing temporary id of staff
							System.err.println("This staff id already exists");
							System.out.println("Try again");
						} else {
							idCheck = true;
						}//end inner if-else
					}//end for

					if (idCheck == false) {
						control2 = true;
					} else {
						control2 = false;
						id = tempId;
					}//end if-else
				} while (control2);
				
				System.out.print("Enter your age(18-65): "); 
				age = input.nextInt();        //take integer value for age
				
				while (age < 18 && age > 65) {          // checks for the age
					System.err.println("Staff member can not be younger than 18 years or older than 65");
					System.out.print("Enter your age(18-65): "); // ask for the age again, if while is true 
					age = input.nextInt();
				}//end while loop
				
				System.out.print("Enter your floor number(0-3): ");
				floorNum = input.nextInt();       //takes integer value for floor number

				while (floorNum > 3 && floorNum < 0) {  // ask for the florr number again, if while is true 
					System.out.println("This building has only 3 floors, try again: ");
					floorNum = input.nextInt();
				} //end while loop

				do {
					System.out.print("Enter your section(A-D): ");// checks for the section
					section = input.next().charAt(0);
					section = Character.toUpperCase(section);
					if (section != 'A' && section != 'B' && section != 'C' && section != 'D')
						System.err.println("Enter a valid section\n");
				} while (section != 'A' && section != 'B' && section != 'C' && section != 'D');

				control = false;

			} catch (Exception e) {
				System.err.println("Unknown Exception: " + e.getMessage());
				System.out.println("Enter again: ");
				input.nextLine();
			}//end try-catch

		} while (control);
	}//end method

}//exit class
