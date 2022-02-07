package LibraryManagement;
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab6
 * Lab Professor - Dr. Anu Thomas
 */
/**
 * Defines various policies of the library
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public interface Policies {

	/**Fine for the user**/
	final public static int FINE =1;//Fine for the user
	/**Time in days allowed for the user to borrow books**/
	final public static int BORROW_TIME=14;//Time in days allowed for the user to borrow books
	/**Maximum books allowed for the user to borrow**/
	final public static int MAX_BOOKS=5;//Maximum books allowed for the user to borrow
	
	/** Calculates the fine */
	public void calculateFine();
	
}//exit class
