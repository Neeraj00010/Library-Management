package LibraryManagement;
import java.io.Serializable;
import java.time.LocalDate;
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab6
 * Lab Professor - Dr. Anu Thomas
 */

/**
 * The purpose of this class is to create a book which act as a super class for different other categories (sub-classes)
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public abstract class Book implements Serializable {
	
	/**Long variable for serializable class*/
	private static final long serialVersionUID = 1L;
	/**Id of the book**/
	protected int bookId;//Id of the book
	/**Genre of the of the book**/
	protected String genre;//Genre of the of the book
	/**Title of the book**/
	protected String title;//Title of the book
	/**Checkout date of the book**/
	protected LocalDate checkoutDate;//Checkout date of the book
	
	/**No-arg constructor with same class name*/
	Book() {} //no-arg constructor

	/** Prints the header and various details of the books*/
	public abstract void printTitle();

	/** Prints the books*/
	public abstract void printBooks();

	/**Prints the book with checkout date listed*/
	public abstract void printBookWithCheckout();

	/**
	 * Registers the checkout date in mutator
	 * @param checkoutDate Checkout Date of the book
	 */
	public void setCheckoutDate(LocalDate checkoutDate) {  //parameterized method
		this.checkoutDate = checkoutDate;
	}
	

	/**
	 * Returns the Checkout date of the book with accessor
	 * @return Checkout date of the book
	 */
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

}//exit class
