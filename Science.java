package LibraryManagement;
import java.io.Serializable;
/**
 * The purpose of this class is to create a book of category of Science
 * @author Karmandeep Singh
 *
 */
public class Science extends NonFiction implements Serializable{

	
	private static final long serialVersionUID = 1L;
	/**Topic of book**/
	protected String topic; //Topic of book
	/**Description of book**/
	protected String description;//Description of book
	
	/**No-arg constructor*/
	Science() {   //No-arg constructo
		super.category="Science";
	}//end constructor
	
	/**
	 * Paramterized constructor
	 * @param bookId for storing book id
	 * @param title for storing title of the book
	 * @param author for storing author of that book
	 * @param topic for storing topic of that book
	 * @param description for storing book description
	 */
	Science(int bookId,String title, String author,String topic, String description) {  //Paramterized constructor
		super.title=title;
		super.author=author;
		this.topic=topic;
		this.description=description;
		super.bookId=bookId;
		super.category="Science";
	}//end constructor

	/**Override constructor for printing header title*/
	@Override
	public void printTitle() {
		super.printTitle();  //method called explicitly
		System.out.printf("%10s | %40s | %35s | %20s | %60s | ", "Category", "Title", "Author", "Topic", "Desciption");
	}//end method
	
	/**Override constructor for printing books*/
	@Override
	public void printBooks() {
		super.printBooks();   //method called explicitly
		System.out.printf("| %10s | %40s | %35s | %20s | %60s",category, title, author, topic, description);
	}//end method
	
	/**Override constructor for printing book with checkout details*/
	@Override
	public void printBookWithCheckout() {
		super.printBooks();  //method called explicitly
		System.out.printf("| %10s | %40s | %35s | %20s | %60s | %20s",category, title, author, topic, description,checkoutDate.toString());
	}//end method
	
}//exit class
