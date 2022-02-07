package LibraryManagement;
import java.io.Serializable;
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab6
 * Lab Professor - Dr. Anu Thomas
 */

/**
 * This method intialize variables for personal details of employee
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public abstract class Person implements Serializable {

	/**Long variable for serializable class*/
	private static final long serialVersionUID = 1L;

	/** The first name of the person **/
	protected String firstName; // stores the first name of the person

	/** The last name of the person **/
	protected String lastName; // stores the last name of the person

	/** The email of the person **/
	protected String emailId; // stores the email of the person

	/** The phone number of the person **/
	protected long phoneNumber; // stores the phone number of the person

	/**No arg constructor for the person class */
	Person() {} 	// no arg constructor

	/**
	 * Parameterized constructor for the person class
	 * @param fName First Name of the person
	 * @param lName The last name of the person
	 * @param email The email of the person
	 * @param ph    The phone number of the person
	 */
	Person(String fName, String lName, String email, long ph) {  // parameterized constructor
		this.firstName = fName;
		this.lastName = lName;
		this.emailId = email;
		this.phoneNumber = ph;
	}
	
}//exit class
