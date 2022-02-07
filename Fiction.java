package LibraryManagement;

import java.io.Serializable;
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab6
 * Lab Professor - Dr. Anu Thomas
 */

/**
 * Purpose of this class is to create a book of fiction genre
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public class Fiction extends Book implements Serializable {

	/**Long variable for serializable class*/
	private static final long serialVersionUID = 1L;
	/** Author of the book **/
	protected String author;// Author of the book
	/** Category of the book **/
	protected String category;// Category of the book

	/**No-arg constructor with same class name*/
	Fiction() {
		super.genre = "Fiction";
	}

	/**Override method for printing title header*/
	@Override
	public void printTitle() {
		System.out.printf("%10s | %15s | ", "Book Id", "Genre");
	}//end method

	/**Override method for printing books*/
	@Override
	public void printBooks() {
		System.out.printf("%10d | %15s ", bookId, genre);
	}//end method

	/**Override method for printing books including checkout details*/
	@Override
	public void printBookWithCheckout() {
		System.out.printf("%10d | %15s ", bookId, genre);
	}//end method

}//exit class
