package LibraryManagement;

import java.io.Serializable;
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab6
 * Lab Professor - Dr. Anu Thomas
 */
/**
 * The purpose of this class is to create a book of category Biography
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public class Biography extends NonFiction implements Serializable{

	/**Long variable for serializable class*/
	private static final long serialVersionUID = 1L;
	/**Person about whom biography is written**/
	protected String about;//Person about whom biography is written
	/**Description of the book**/
	protected String description;//Description of the book

	/**
	 * Parameterized constructor 
	 * @param bookId for storing book id
	 * @param title for storing title of the book
	 * @param author for storing author of that book
	 * @param about for storing person name on whom that book is inspired
	 * @param description for storing book description
	 */
	Biography(int bookId,String title, String author, String about, String description) {  //Paramterized constructor
		super.title = title;
		super.author = author;
		super.category = "Biography";
		this.about = about;
		this.description = description;
		super.bookId = bookId;
	}//end constructor

	/**Override constructor for printing header title*/
	@Override
	public void printTitle() {
		super.printTitle();    //method called explicitly
		System.out.printf("%10s | %40s | %35s | %20s | %60s | ", "Category", "Title", "Author", "About", "Desciption");
	}//end method

	/**Override constructor for printing books*/
	@Override
	public void printBooks() {
		super.printBooks();   //method called explicitly
		System.out.printf("| %10s | %40s | %35s | %20s | %60s", category, title, author, about, description);
	}//end method
	
	/**Override constructor for printing book with checkout details*/
	@Override
	public void printBookWithCheckout() {
		super.printBooks();   //method called explicitly
		System.out.printf("| %10s | %40s | %35s | %20s | %60s | %30s",category, title, author, about, description,checkoutDate.toString());
		System.out.println();
	}//end method
	
}//exit class
