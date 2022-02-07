package LibraryManagement;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Student Name: Neeraj Kumar Bansal
 * Lab Professor Name: Anu Thomas
 * Lab Section Number: 301
*/
/**
 * The purpose of this class is to create a user and further extend it to
 * customer and staff
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public class User extends Person implements Serializable, Policies {
	
	/** ID for serializable class */
	private static final long serialVersionUID = 1L;
	/** Id of the user **/
	protected long id;// Id of the user
	/** Type of user **/
	protected String type;// Type of user

	protected ArrayList<Book> books = new ArrayList<Book>();
	
	/** Fine to be paid by the user **/
	protected static long totalFine;// Fine to be paid by the user
	
	/**Declares format for date to print*/
	DateTimeFormatter format; //

	/**No-arg constructor with same class name*/
	User() {}

	/**
	 * Parameterized constructor
	 * @param books for array list of class book
	 */
	User(ArrayList<Book> books) {
		super();  //constructor called of parent class
		this.books = books;
	}//end constructor

	/** Reads various attributes of the user from keyboard
	 * @param input takes input from user
	 */
	public void readPerson(Scanner input) {
		
		System.out.print("Enter First Name: ");
		firstName = input.next();

		System.out.print("Enter Last Name: ");
		lastName = input.next();

		System.out.print("Enter your email: ");
		emailId = input.next();

		System.out.print("Enter your phone number: ");
		phoneNumber = input.nextLong();
	}//end method

	/**
	 * Adds a book to the user's account
	 * @param chosenBook Book chosen by the user
	 */
	protected void setBook(Book chosenBook) {
		calculateFine();   //method call from interface
		
		if (books.size() < Policies.MAX_BOOKS && totalFine == 0) {
			books.add(chosenBook);       //add book to the arraylist
			books.get(books.indexOf(chosenBook)).setCheckoutDate(LocalDate.now()); // sets the checkout date to current date																
			System.out.println("Book has been issued");
		} else {
			System.out.println("You can not borrow more books");
		}//end if-else
		if (totalFine != 0) {          //check fine is zero or not
			System.out.println("You can not borrow books until you have paid the pending fines");
		}//end if
	}//exit method

	/**
	 * Returns the type of user (accessor)
	 * @return Type of user
	 */
	public String getType() {    //accessor method
		return type;
	}//end method

	/**
	 * Returns the id of user (accessor)
	 * @return Id of user
	 */
	public long getId() {     //accessor method
		return id;
	}//end method

	/**
	 * Returns the full name of user (accessor)
	 * @return Id of user
	 */
	public String getFullName() {  //accessor method
		return firstName + " " + lastName;
	}//end method

	/** Print all the borrowed books */
	public void printBorrowedBooks() {

		if (books.size() == 0) {         //check if the size of the book is zero
			System.out.println("No books borrowed");
		}
		
		for (Book b : books) {
			b.printTitle();   //method call using object

			System.out.printf("%30s |", "Checkout Date");
			System.out.println();
			b.printBookWithCheckout();  //method call using object
			System.out.println();
		}//end for loop
		
	}//end method

	/**Calculates the fine due by the user */
	@Override
	public void calculateFine() {
		totalFine = 0;
		if (books.size() != 0) {
			for (int i = 0; i < books.size(); i++) {
				totalFine += (ChronoUnit.DAYS.between(books.get(i).getCheckoutDate(), LocalDate.now()) - 14)
						* Policies.FINE;

			}//end for loop

			if (totalFine < 0) {
				totalFine = 0;
			}//end inner-if

		}//end outer-if statement

	}//exit method

	/**
	 * Returns fine due by the user (accessor)
	 * @return Fine due by the user
	 */
	public long getFine() {
		calculateFine();  //method called
		return totalFine;
	}//end method

	/**
	 * Pays the fine and returns the book
	 * @param paidFine Amount deposited by the user
	 */
	public void payFine(int paidFine) {
		calculateFine(); //method called
		totalFine = totalFine - paidFine;
		books.removeAll(books); //remove books from array
		System.out.println("Fine has been paid and all books have been deposited");
	}//end method

} //exit class
