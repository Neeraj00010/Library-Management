package LibraryManagement;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab6
 * Lab Professor - Dr. Anu Thomas
 */

/**
 * The library class is for maintaining system of the library
 * @author Neeraj Kumar Bansal
 * @version 1.0
 * @since 1.8
 */
public class Library implements Serializable {

	/** ID for serializable class */
	private static final long serialVersionUID = 1L;
	/**instance variable for storing name of the library*/
	private String libraryName;
	/**Interface for reading entire object*/
	private static ObjectOutputStream outputObj;
	/**Interface for writing entire object*/
	private static ObjectInputStream inputObj;

	/**users named array list with class User reference*/
	static ArrayList<User> users = new ArrayList<User>();

	/**category named different array lists with class Books reference*/
	ArrayList<Book> fantasy = new ArrayList<Book>();
	ArrayList<Book> comic = new ArrayList<Book>();
	ArrayList<Book> science = new ArrayList<Book>();
	ArrayList<Book> history = new ArrayList<Book>();
	ArrayList<Book> biography = new ArrayList<Book>();
	ArrayList<Book> books = new ArrayList<Book>();

	final protected static int MEMBER = 1;  //constant variable
	final protected static int STAFF = 2;   //constant variable

	/**
	 * Parameterized constructor
	 * @param name for library name
	 * @param input for taking inputs
	 */
	Library(String name, Scanner input) {
		libraryName = name;
		readBooks(input);
		readUsers();
	}//end constructor

	/**
	 * Adds members to the database
	 * @param input Reads input from the user and a file
	 */
	public void addUser(Scanner input) {
		int option = 0;
		boolean control = true;
		do {
			System.out.println("1. New Member");
			System.out.println("2. New Staff");
			System.out.println("3. <-Go Back");

			System.out.print("Enter your option: ");
			option = input.nextInt();
			
			while(option != 1 || option != 2 || option != 3) {
				System.out.println("Inavalid option");
				System.out.print("Enter your option: ");
				option = input.nextInt();
			}//end while
			try {
			switch (option) {
			case MEMBER:// creates a customer
				users.add(new Member());
				users.get(users.size() - 1).readPerson(input);
				control = false;
				break;
			case STAFF:// creates a staff member
				users.add(new Staff());
				users.get(users.size() - 1).readPerson(input);
				control = false;
				break;
			case 3:
				control = false;
				break;
			default:
				System.err.println("Wrong option entered");
				System.out.print("Enter correct option: ");
				break;

			}//end switch-case statements
			}catch(Exception e) {
				System.out.println("Unknown exception: " + e.getMessage());
			}//end try-catch
		} while (control);
	}// exit method

	/**
	 * Reads books from files
	 * @param input Reads details from a file
	 */
	public void readBooks(Scanner input) {
		// reads all the books from their corresponding files
		readFantasy(input);
		readComic(input);
		readScience(input);
		readHistory(input);
		readBiography(input);

		books.addAll(fantasy);
		books.addAll(comic);
		books.addAll(science);
		books.addAll(history);
		books.addAll(biography);
	}// exit method

	/**
	 * Reads and stores fantasy books
	 * @param input Reads details from a file
	 */
	private void readFantasy(Scanner input) {
		File file = new File("src\\LibraryManagement\\fantasy.txt");
		try {
			input = new Scanner(file);
			input.useDelimiter(",");
		} catch (IOException ioe) {
			System.out.println("IO Exception while opening the file");
		} catch (Exception e) {
			System.out.println("Unknown exception");
			e.printStackTrace();
		} // end try-catch
		while (input.hasNext()) {
			fantasy.add(new Fantasy(input.nextInt(), input.next(), input.next(), input.next(), input.next()));

		} // end while loop
	}// exit method

	/**
	 * Reads and stores comic books
	 * 
	 * @param input Reads details from a file
	 */
	private void readComic(Scanner input) {
		try {
			input = new Scanner(Paths.get("src\\LibraryManagement\\comic.txt"));
			input.useDelimiter(",");
		} catch (IOException ioe) {
			System.out.println("IO Exception while opening the file");
		} catch (Exception e) {
			System.out.println("Unknown exception");
			e.printStackTrace();
		} // end try-catch
		while (input.hasNext()) {
			comic.add(new Comic(input.nextInt(), input.next(), input.next(), input.next(), input.next()));

		} // end while loop
	}// exit method

	/**
	 * Reads and stores science books
	 * @param input Reads details from a file
	 */
	private void readScience(Scanner input) {
		File file = new File("src\\LibraryManagement\\science.txt");
		try {
			input = new Scanner(file);
			input.useDelimiter(",");
		} catch (IOException ioe) {
			System.out.println("IO Exception while opening the file");
		} catch (Exception e) {
			System.out.println("Unknown exception");
			e.printStackTrace();
		} // end try-catch
		while (input.hasNext()) {
			science.add(new Science(input.nextInt(), input.next(), input.next(), input.next(), input.next()));

		} // end while loop
	}// exit method

	/**
	 * Reads and stores history books
	 * 
	 * @param input Reads details from a file
	 */
	private void readHistory(Scanner input) {

		try {
			input = new Scanner(Paths.get("src\\LibraryManagement\\history.txt"));
			input.useDelimiter(",");
		} catch (IOException ioe) {
			System.out.println("IO Exception while opening the file");
		} catch (Exception e) {
			System.out.println("Unknown exception");
			e.printStackTrace();
		} // end try-catch
		while (input.hasNext()) {
			history.add(new History(input.nextInt(), input.next(), input.next(), input.next(), input.next()));

		} // end while loop
	}// exit method

	/**
	 * Reads and stores biography books
	 * 
	 * @param input Reads details from a file
	 */
	private void readBiography(Scanner input) {

		try {
			input = new Scanner(Paths.get("src\\LibraryManagement\\biography.txt"));
			input.useDelimiter(",");
		} catch (IOException ioe) {
			System.out.println("IO Exception while opening the file");
		} catch (Exception e) {
			System.out.println("Unknown exception");
			e.printStackTrace();
		} // end try-catch
		while (input.hasNext()) {
			biography.add(new Biography(input.nextInt(), input.next(), input.next(), input.next(), input.next()));
		} // end while loop
	}// exit method

	/**
	 * Prints all the books borrowed by a user
	 * @param userLogin Specifies the user
	 * @param input     Reads input from the user
	 */
	public void existingUserPrintBooks(User userLogin, Scanner input) {
		userLogin.printBorrowedBooks();
	}// exit method

	/**
	 * Adds books to the user
	 * 
	 * @param userLogin Specifies the user
	 * @param input     Reads input from the user
	 */
	public void userAddBook(User userLogin, Scanner input) {
		long tempId;
		boolean control = true;
		do {// allows the user to enter details in case of wrong input
			System.out.print("Enter book id: ");
			tempId = input.nextLong();
			for (int i = 0; i < books.size(); i++) {

				if (tempId == books.get(i).bookId) {// checks for book id in database
					userLogin.setBook(books.get(i));
					i = books.size();
					control = false;
				} // end if
			} // end for
			if (control)
				System.err.println("Invalid book id entered");
		} while (control);
	}// exit method

	/**
	 * A menu for customer interaction
	 * 
	 * @param userLogin Specifies the customer
	 * @param input     Reads input from the Member
	 */
	private void memberInteraction(User userLogin, Scanner input) {
		int choice = 0;
		userLogin.calculateFine();  //method called
		boolean control = true;

		do {// keeps the user in menu until user chooses to exit
			if (userLogin.getFine() != 0) {
				System.out.println("****** You have unpaid fine ******");
			} // displays this header if user has unpaid fine
			userLogin.calculateFine();
			try {
			System.out.println("1. Issue a  Book");
			System.out.println("2. Check for fine");
			System.out.println("3. Pay for fine");
			System.out.println("4. Show all borrowed books");
			System.out.println("5. Print all books");
			System.out.println("6. Return book");
			System.out.println("7. Remove this user");
			System.out.println("8. <-Go Back");
			System.out.print("Enter option: ");
			choice = input.nextInt();
			}catch(InputMismatchException ime) {
				System.out.println("Invalid entry");
			}catch(Exception e) {
				System.out.println("Unknown exception: " + e.getMessage());
			}//end try-catch
			switch (choice) {
			case 1:
				userAddBook(userLogin, input);// allows the user to borrow books
				break;
			case 2:
				System.out.println("Fine: $" + userLogin.getFine());// returns fine to the user
				break;
			case 3:
				int tempFine;
				if (userLogin.getFine() != 0) { // allows the user to pay fine
					do {
						System.out.println("Fine: $" + userLogin.getFine());
						System.out.print("Enter amount: ");

						tempFine = input.nextInt();

						if (tempFine != userLogin.getFine()) // prompts the user to enter exact amount
							System.out.println("Enter exact fine");

						else {
							userLogin.payFine(tempFine);// pays the fine
							tempFine = 0;
						}

					} while (tempFine != userLogin.getFine());
				} else {
					System.out.println("No fine to pay");
				}
				break;
			case 4:
				existingUserPrintBooks(userLogin, input);// prints all the books borrowed by the user
				break;
			case 5:
				printBooks(input);// prints all or some books according to the user input
				break;
			case 6:

				if (userLogin.books.size() != 0) {// checks if user has borrowed any books or not
					if (User.totalFine != 0) {// checks if user has unpaid fine
						int tempFine2;
						do { // tells user to pay fine
							System.out.println("Fine: $" + userLogin.getFine());
							System.out.print("Enter amount: ");

							tempFine2 = input.nextInt();
							if (tempFine2 != userLogin.getFine())
								System.out.println("Enter exact fine");

							else {
								userLogin.payFine(tempFine2);
								tempFine2 = 0;
							}

						} while (tempFine2 != userLogin.getFine());
					} else {
						int option2 = 0;
						do {

							System.out.println("1. Return all books");
							System.out.println("2. Return a specific book");
							System.out.print("Enter option: ");
							option2 = input.nextInt();

							if (option2 == 1) {// removes all the books
								userLogin.books.removeAll(userLogin.books);
								System.out.println("All books deposited");
							} else if (option2 == 2) {// removes a specific book
								returnBook(userLogin, input);
							} else {
								System.err.println("Enter a valid option");
							}
						} while (option2 != 1 && option2 != 2);
					}
				} else {
					System.out.println("*** No borrowed books ***");
				}
				break;
			case 7:
				if (User.totalFine == 0) {// checks if user has unpaid fine or not before removing the user
					String choice2 = "";
					System.out.println("Are You sure you want to remove this user(Y/N)"); // deletes the user
					choice2 = input.next();
					if (choice2.equals("Y") || choice2.equals("y")) {
						for (int i = 0; i < users.size(); i++) {
							if ((userLogin.getId() == users.get(i).getId()) && users.get(i).type.equals("Member")) {
								users.remove(i);
							}
						}
						control = false;
					}
				} else {
					System.out.println("You cannot borrow a book without paying the previous fine");
				}
				break;
			case 8:
				control = false;
				break;
			default:
				System.err.println("Enter a valid option");
				control = true;
				break;
			}// end switch

		} while (control);
	}// exit method

	/**
	 * A menu for staff interaction
	 * 
	 * @param userLogin Specifies the staff member
	 * @param input     Reads input from the staff member
	 */
	private void staffInteraction(User userLogin, Scanner input) {
		int choice = 0;
		userLogin.calculateFine();
		boolean control = true;

		do {
			if (userLogin.getFine() != 0) {
				System.out.println("****** You have unpaid fine ******");
			}//end if
			try {
			userLogin.calculateFine();
			System.out.println("1. Issue a Book");
			System.out.println("2. Check for fine");
			System.out.println("3. Pay for fine");
			System.out.println("4. Show all borrowed books");
			System.out.println("5. Print all books");
			System.out.println("6. Return book");
			System.out.println("7. Remove this user");
			System.out.println("8. List all customers");
			System.out.println("9. Display terms and conditions");
			System.out.println("10. <-Go Back");
			System.out.print("Enter option: ");
			choice = input.nextInt();
		}catch(InputMismatchException ime) {
			System.err.println("Invalid entry");
		}catch(Exception e) {
			System.err.println("Unknown exception: " + e.getMessage());
		}//end try-catch
		
			switch (choice) {
			case 1:
				userAddBook(userLogin, input);// allows the user to borrow books
				break;
			case 2:
				System.out.println("Fine: $" + userLogin.getFine());// returns fine to the user
				break;
			case 3:
				int tempFine;
				if (userLogin.getFine() != 0) {
					do {
						System.out.println("Fine: $" + userLogin.getFine());
						System.out.print("Enter amount: ");

						tempFine = input.nextInt();
						if (tempFine != userLogin.getFine())
							System.out.println("Enter exact fine");

						else {
							userLogin.payFine(tempFine);// pays the fine
							tempFine = 0;
						}

					} while (tempFine != userLogin.getFine());
				} else {
					System.out.println("No fine to pay");
				}
				break;
			case 4:
				existingUserPrintBooks(userLogin, input);// prints all the books borrowed by the user
				break;
			case 5:
				printBooks(input);// prints all or some books according to the user input
				break;
			case 6:

				if (userLogin.books.size() != 0) {
					if (User.totalFine != 0) {// checks for fine
						int tempFine2;
						do {
							System.out.println("Fine: $" + userLogin.getFine());
							System.out.print("Enter amount: ");

							tempFine2 = input.nextInt();
							if (tempFine2 != userLogin.getFine())
								System.out.println("Enter exact fine");

							else {
								userLogin.payFine(tempFine2);// allows the user to pay fine
								tempFine2 = 0;
							}

						} while (tempFine2 != userLogin.getFine());
					} else {
						int option2 = 0;
						do {

							System.out.println("1. Return all books");
							System.out.println("2. Return a specific book");
							System.out.print("Enter: ");
							option2 = input.nextInt();

							if (option2 == 1) {
								userLogin.books.removeAll(userLogin.books);// returns all the books
								books.addAll(userLogin.books);
								System.out.println("All books deposited");
							} else if (option2 == 2) {
								returnBook(userLogin, input);// allows the user to return a specific book
							} else {
								System.err.println("Enter a valid option");
							}
						} while (option2 != 1 && option2 != 2);
					}
				} else {
					System.out.println("No borrowed books");
				}
				break;
			case 7:
				if (User.totalFine == 0) {// checks for fine before deleting the user
					String choice2 = "";
					System.out.println("Are You sure you want to remove this user(Y/N)");
					choice2 = input.next();
					if (choice2.equals("Y") || choice2.equals("y")) {
						for (int i = 0; i < users.size(); i++) {
							if ((userLogin.getId() == users.get(i).getId()) && users.get(i).type.equals("Staff")) {
								users.remove(i);
							}
						}
						control = false;
					}
				} else {
					System.out.println("User can not be deleted without paying the fine");
				}
				break;
			case 8:
				int count = 0;

				for (User u : users) {// checks whether there are customers in the database or not
					if (u.type.equals("Member")) {
						count++;
					}
				}

				if (count != 0) {
					for (int i = 0; i < users.size(); i++) { // prints details of all the customers
						if (users.get(i).type.equals("Member")) {
							System.out.printf("%25s | %25s | %15s | %15s | %10s | %n", "Customer Id", "Name", "Email",
									"Phone number", "fine");
							System.out.printf("%25d | %25s | %15s | %15d | %10d | %n", users.get(i).id,
									users.get(i).getFullName(), users.get(i).emailId, users.get(i).phoneNumber,
									users.get(i).getFine());
							System.out.println("List of all the books: ");
							users.get(i).printBorrowedBooks();

						}
					}
				} else {
					System.out.println("No members in the database");
				}
				break;
			case 9:
				System.out.println();
				System.out.println("1. Duration for borrowing the boooks: 14 days");
				System.out.println("2. Fine upon exceeding due date: $1 per day(after the 14th day)");
				System.out.println("3. Max books allowed per user: 5 books");
				System.out.println();
				break;
			case 10:
				control = false;
				break;
			default:
				System.err.println("Enter a valid option");
				control = true;
				break;

			}

		} while (control);
	}

	/**
	 * A menu for user interaction
	 * 
	 * @param userLogin Specifies the user
	 * @param input     Reads input from the user
	 */
	public void userInteraction(User userLogin, Scanner input) {

		userLogin = userLogin(input);

		if (userLogin != null) {
			try {
			if (userLogin.type.equals("Member")) { // customer interaction
				memberInteraction(userLogin, input);
			} else if (userLogin.type.equals("Staff")) {// staff interaction
				staffInteraction(userLogin, input);
			}
			else {
				System.out.println("Invalid option");
			}//end inner if-else
			}catch(Exception e) {
				System.out.println("Unknown exception: " + e.getMessage());
			}
		}//end outer if
	}

	/**
	 * Allows the user to return book
	 * 
	 * @param userLogin Specifies the user
	 * @param input     Reads user input
	 */
	public void returnBook(User userLogin, Scanner input) {

		long tempId;
		boolean control = true;
		do {
			System.out.print("Enter the book id of the book that you want to return: ");
			tempId = input.nextLong();
			for (int i = 0; i < userLogin.books.size(); i++) {

				if (tempId == userLogin.books.get(i).bookId) { // removes a specific book
					userLogin.books.remove(i);
					System.out.println("Book deposited");
					i = 5;
					control = false;
				}
			}
			if (control)
				System.err.println("Invalid book id entered");
		} while (control);

	}

	/**
	 * Specifies a particular user
	 * 
	 * @param input Reads input from the user
	 * @return A specific user matching the provided details
	 */
	public User userLogin(Scanner input) {
		int option;
		User output = null;

		boolean control = true;
		do {
			System.out.println("1. Member login");
			System.out.println("2. Staff login");
			System.out.println("3. <-Go Back");
			System.out.print("Enter option: ");
			option = input.nextInt();

			switch (option) {
			case 1:
				int count = 0;
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).type.equals("Member")) {
						count++;
					}
				}

				long tempId;
				if (count != 0) {
					do {
						System.out.print("Please enter member id: ");
						tempId = input.nextLong();
						for (int i = 0; i < users.size(); i++) {
							if (tempId == users.get(i).getId() && users.get(i).getType().equals("Member")) {
								output = users.get(i); // outputs the desired member
								i = users.size();
							}
						}
						if (output == null)
							System.err.println("Invalid id entered");
						else {
							control = false;
						}

					} while (output == null);
				} else {
					System.err.println("*** No members in the database ***");
					control = true;
				}
				break;

			case 2:
				int count2 = 0;

				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).type.equals("Staff")) {
						count2++;
					}

				}
				if (count2 != 0) {
					do {
						System.out.print("Please enter staff id: ");
						tempId = input.nextLong();
						for (int i = 0; i < users.size(); i++) {
							if (tempId == users.get(i).getId() && users.get(i).getType().equals("Staff")) {
								output = users.get(i); // outputs the desired staff member
							}
						}
						if (output == null)
							System.err.println("Invalid id entered");
						else {
							control = false;
						}

					} while (output == null);
				} else {
					System.err.println("No Staff in the database");
					control = true;
				}

				break;
			case 3:
				control = false;
				break;
			default:
				System.err.println("Invalid option selected");
				control = true;

			}
		} while (control);
		return output;

	}//exit method
	
	/**
	 * Menu for initisl operations
	 * @param input for taking inputs
	 */
	public void userMenu(Scanner input) {
		int option = 0;
		boolean control = true;

		do {
			System.out.println("\n\n\t\t\tWelcome to " + libraryName + " Library\n");
			
			for (int i = 0; i < 80; i++) {
				System.out.print("*");
			} // end for loop
			
			System.out.println();
			System.out.println("1. Print books");
			System.out.println("2. Existing User Login");
			System.out.println("3. New user");
			System.out.println("4. Display terms and conditions");
			System.out.println("5. List all staff(Administrator)");
			System.out.println("6. Exit");

			try {
				System.out.print("Enter option: ");
				option = input.nextInt();
			} catch (InputMismatchException ime) {
				System.err.println("\n*** Wrong option entered ***");
				input.next();
			} catch (IllegalArgumentException iae) {
				System.err.println("\n*** Wrong option entered ***");
				input.next();
			} catch (Exception e) {
				System.err.println("\nUnknown Exception: " + e.getMessage());
				input.next();
			}

			switch (option) {
			case 1:
				printBooks(input);
				break;
			case 2:
				if (users.size() == 0) {// checks if there are any users in the database or not
					System.err.println("*** No users found ***");
				} else {
					userInteraction(null, input);
				}
				break;
			case 3:
				addUser(input); // adds user to the database
				break;

			case 4:
				System.out.println();
				System.out.println("1. Duration for borrowing the boooks: 14 days");
				System.out.println("2. Fine upon exceeding due date: $1 per day(after the 14th day)");
				System.out.println("3. Max books allowed per user: 5 books");
				System.out.println();
				break;
			case 5:
				int count = 0;

				for (User u : users) {// checks whether there are staff in the database or not
					if (u.type.equals("Staff")) {
						count++;
					}
				}//end for

				if (count != 0) {
					for (int i = 0; i < users.size(); i++) { // prints details of all the staff
						if (users.get(i).type.equals("Staff")) {
							System.out.printf("%25s | %25s | %25s | %15s | %10s | %n", "Staff Id", "Name", "Email",
									"Phone number", "fine");
							System.out.printf("%25d | %25s | %25s | %15d | %10d | %n", users.get(i).id,
									users.get(i).getFullName(), users.get(i).emailId, users.get(i).phoneNumber,
									users.get(i).getFine());
						}
					}
				} else {
					System.err.println("No staff in the database");
				}
				break;
			case 6:
				control = false;
				System.out.println("Thank you for using the program");
				writeUsers();// saves user data to a particular file
				break;
			default:
				System.err.println("\\n*** Wrong option entered ***");
				control = true;
				break;
			}

		} while (control);
	}

	/**
	 * Prints books
	 * 
	 * @param input Reads user input
	 */
	public void printBooks(Scanner input) {

		int choice = 1;
		System.out.println("1. Print all books");
		System.out.println("2. Print Fantasy books");
		System.out.println("3. Print Comic books");
		System.out.println("4. Print Science books");
		System.out.println("5. Print History books");
		System.out.println("6. Print Biography books");

		do {
			System.out.print("Enter option: ");
			choice = input.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6)
				System.err.println("Enter a valid option");

		} while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6);
		try {
		switch (choice) {

		case 1:

			printAllBooks();// prints all books

			break;
		case 2:
			for (int i = 0; i < fantasy.size(); i++) {
				if (i == 0) {
					fantasy.get(i).printTitle();
					System.out.println();
					for (int j = 0; j < 210; j++)
						System.out.print("*");

					System.out.println();
					fantasy.get(i).printBooks();
				} else {
					fantasy.get(i).printBooks();
				}
			}
			break;
		case 3:
			for (int i = 0; i < comic.size(); i++) {
				if (i == 0) {
					comic.get(i).printTitle();
					System.out.println();
					for (int j = 0; j < 210; j++)
						System.out.print("*");

					System.out.println();
					comic.get(i).printBooks();
				} else {
					comic.get(i).printBooks();
				}
			}
			break;
		case 4:
			for (int i = 0; i < science.size(); i++) {
				if (i == 0) {
					science.get(i).printTitle();
					System.out.println();
					for (int j = 0; j < 210; j++)
						System.out.print("*");

					System.out.println();
					science.get(i).printBooks();
				} else {
					science.get(i).printBooks();

				}
			}
			break;
		case 5:
			for (int i = 0; i < history.size(); i++) {
				if (i == 0) {
					history.get(i).printTitle();
					System.out.println();
					for (int j = 0; j < 210; j++)
						System.out.print("*");

					System.out.println();
					history.get(i).printBooks();
				} else {
					history.get(i).printBooks();
				}
			}
			break;
		case 6:
			for (int i = 0; i < biography.size(); i++) {
				if (i == 0) {
					biography.get(i).printTitle();
					System.out.println();
					for (int j = 0; j < 210; j++)
						System.out.print("*");

					System.out.println();
					biography.get(i).printBooks();
				} else {
					biography.get(i).printBooks();
				}
			}
			break;
		}//end switch-case
		}catch(InputMismatchException ime){
			System.out.print(ime);
		}catch(Exception e) {
			System.out.println("Unknown exception: " + e.getMessage());
		}//end try-catch

	}//exit method

	/**
	 * Prints all books
	 */
	private void printAllBooks() {
		for (int i = 0; i < fantasy.size(); i++) {
			if (i == 0) {
				fantasy.get(i).printTitle();
				System.out.println();
				for (int j = 0; j < 210; j++)
					System.out.print("*");

				System.out.println();
				fantasy.get(i).printBooks();
			} else {
				fantasy.get(i).printBooks();
			}
		}


		for (int i = 0; i < comic.size(); i++) {
			if (i == 0) {
				comic.get(i).printBooks();
			} else {
				comic.get(i).printBooks();
			}
		}
		System.out.println();
		for (int i = 0; i < science.size(); i++) {
			if (i == 0) {
				science.get(i).printBooks();
			} else {
				science.get(i).printBooks();

			}
		}

		System.out.println();
		for (int i = 0; i < history.size(); i++) {
			if (i == 0) {
				history.get(i).printBooks();
			} else {
				history.get(i).printBooks();
			}
		}
		System.out.println();
		for (int i = 0; i < biography.size(); i++) {
			if (i == 0) {
				biography.get(i).printBooks();
			} else {
				biography.get(i).printBooks();
			}
		}
		System.out.println();
	}//exit method

	/**
	 * Saves user data to a file
	 */
	private void writeUsers() {

		try {
			outputObj = new ObjectOutputStream(Files.newOutputStream(Paths.get("src\\LibraryManagement\\users.ser")));
		} catch (IOException i) {
			System.out.println(i);
		}
		try {
			for (User u : users) {
				outputObj.writeObject(u);     //write input
			}
		} catch (IOException io) {

		}
	}

	/**
	 * Reads user data from a specific file
	 */
	private void readUsers() {
		try {
			inputObj = new ObjectInputStream(Files.newInputStream(Path.of("src\\LibraryManagement\\users.ser")));   //open file
		} catch (Exception e) {

		}

		while (true) {
			try {
				users.add((User) inputObj.readObject());  //read entire object
			} catch (EOFException e) {
				break;

			} catch (ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			} catch (IOException ioe) {
				System.out.println(ioe);
			} catch (NullPointerException n) {
				break;
			}
		}//end while
	}// exit method

}//exit class
