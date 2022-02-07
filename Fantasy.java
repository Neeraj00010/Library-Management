package LibraryManagement;
import java.io.Serializable;
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab6
 * Lab Professor - Dr. Anu Thomas
 */
/**
 * The purpose of this class is to create a book of category comic
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public class Fantasy extends Fiction implements Serializable{

	/**Long variable for serializable class*/
	private static final long serialVersionUID = 1L;
	/**Theme of book**/
	protected String theme; //Theme of book
	/**Description of the book**/
	protected String description;//Description of the book 
	
	/**
	 * Paramterized constructor
	 * @param bookId for storing book id
	 * @param title for storing title of the book
	 * @param author for storing author of that book
	 * @param theme for storing theme of that book
	 * @param description for storing book description
	 */
	public Fantasy( int bookId, String title, String author, String theme, String description) {   //Paramterized constructor
		super.title=title;
		super.category="Fantasy";
		super.author=author;
		this.theme=theme;
		this.description=description;
		this.bookId=bookId;
	}//end constructor

	/**Override constructor for printing header title*/
	@Override
	public void printTitle() {
		super.printTitle();   //method called explicitly
		System.out.printf("%10s | %40s | %35s | %20s | %60s | ", "Category", "Title", "Author", "Theme", "Desciption");
	}//end method
	
	/**Override constructor for printing books*/
	@Override
	public void printBooks() {
		super.printBooks();  //method called explicitly
		System.out.printf("| %10s | %40s | %35s | %20s | %60s",category, title, author, theme, description);
	}//end method
	
	/**Override constructor for printing book with checkout details*/
	@Override
	public void printBookWithCheckout() {
		super.printBooks();  //method called explicitly
		System.out.printf("| %10s | %40s | %35s | %20s | %60s | %30s",category, title, author, theme, description,checkoutDate.toString());
	}//end method
	
}//exit class
