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
 * The purpose of this class is to create a user of type Member
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public class Member extends User implements Serializable {

	/**Long variable for serializable class*/
	private static final long serialVersionUID = 1L;

	/**No-arg constructor with same class name*/
	Member() {
		super.type = "Member";
	}

	/**
	 * Sets the customer id (mutator)
	 * @param custId for Customer id
	 */
	protected void setCustId(long custId) {
		super.id = custId;
		super.type = "Member";
	}//exit method

	/**Override method for reading personal details of person
	 * @param input for taking inputs from user
	 */
	@Override
	public void readPerson(Scanner input) {
		super.readPerson(input);        //method called explicitly
		boolean control = true;         //boolean type local variable 
		boolean idCheck = true;         //boolean type local variable 
		int tempId = 0;                //local variable for storing temporary id of member

		do {
			System.out.print("Enter Member Id: ");
			tempId = input.nextInt();                   

			for (int i = 0; i < Library.users.size(); i++) {
				if ((tempId == Library.users.get(i).getId()) && Library.users.get(i).type.equals("Member")) {
					idCheck = false;             //end boolean 
					i = Library.users.size();     //check if id of member is already exists
					System.err.println("This member id already exists");
					System.out.println("Try again");
				} // end inner-if
				else {
					idCheck = true;
				} // end else
			} // end for

			if (idCheck == false) {
				control = true;
			} else {
				control = false;
				id = tempId;
			}//end if-else
			
		} while (control);
	}// exit method

	/**
	 * Returns the customer id
	 * @return Customer id
	 */
	protected long getCustId() {
		return id;
	}// exit accessor

}// exit class
