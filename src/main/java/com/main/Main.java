package com.main;

import java.util.Scanner;

import com.bean.BookStore;
import com.service.BookStoreService;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BookStoreService bser = new BookStoreService();
		int book_id;
		String book_name;
		String genere_type;
		String book_author;
		String book_description;
		int book_price;
		int no_of_books_sold;
		int choice;
		int bookchoice;
		String res;
		String con;
		String bookcon = "done";
		String findbyGenereType;
		String role;
		do {
			System.out.println("Please enter your Role(Admin/User):-");
			role = sc.nextLine();
			if (!role.equalsIgnoreCase("Admin")) {
				System.out.println("Invalid Role!");
				System.out.println("Please ReEnter");
			}
		} while (!role.equalsIgnoreCase("Admin"));
		do {
			System.out.println("******Menu*******");
			System.out.println("1.Add a new Book");
			System.out.println("2.Delete a Book");
			System.out.println("3.Update a Book");
			System.out.println("4.Display All the Books");
			System.out.println("Please enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Book name");
				sc.nextLine();
				book_name = sc.nextLine();
				System.out.println("Enter Book Genre");
				genere_type = sc.nextLine();
				System.out.println("Enter Book Author");
				book_author = sc.nextLine();
				System.out.println("Enter Book description");
				book_description = sc.nextLine();
				System.out.println("Enter Book Price");
				book_price = sc.nextInt();
				System.out.println("Enter number of Copies sold");
				no_of_books_sold = sc.nextInt();
				BookStore bs = new BookStore(book_name, genere_type, book_author, book_description, book_price,
						no_of_books_sold);
				res = bser.addBook(bs);
				System.out.println(res);
				break;
			case 2:
				bser.retriveAllBooks();
				System.out.println("Please Enter the Book name id you want to delete");
				book_id = sc.nextInt();
				res = bser.deleteBook(book_id);
				System.out.println(res);
				break;
			case 3:
				bser.retriveAllBooks();
				System.out.println("Please Enter the Book name id you want to Update");
				book_id = sc.nextInt();
				System.out.println("Please Enter new information");
				System.out.println("Enter Book Price");
				book_price = sc.nextInt();
				System.out.println("Enter number of Coipes sold");
				no_of_books_sold = sc.nextInt();
				sc.nextLine();
				BookStore bs1 = new BookStore();
				bs1.setBook_id(book_id);
				bs1.setBook_price(book_price);
				bs1.setSold_copies(no_of_books_sold);
				res = bser.updateBook(bs1);
				System.out.println(res);
				break;
			case 4:
				do {
					System.out.println("******Menu*******");
					System.out.println("1.Display Book count");
					System.out.println("2.Display via Genere");
					System.out.println("3.Book Information");
					System.out.println("4.Arrange price low to high");
					System.out.println("5.Arrange price high to low");
					System.out.println("6.Arrange best selling on Top");
					System.out.println("Please enter your choice");
					bookchoice = sc.nextInt();
					switch (bookchoice) {
					case 1:
						bser.totalBooksCount();
						break;
					case 2:
						System.out.println("Please Enter the Genere");
						findbyGenereType = sc.next();
						bser.findBookByGenere(findbyGenereType);
						break;
					case 3:
						bser.retriveAllBooks();
						System.out.println("Please Enter the Book name id you want to Describe");
						book_id = sc.nextInt();
						bser.retriveById(book_id).forEach(e -> System.out.println(e));
						break;
					case 4:
						bser.findBooksByLtoHPrice();
						break;
					case 5:
						bser.findBooksByHtoLPrice();
						break;
					case 6:
						bser.findMostSellingBook().forEach(e -> System.out.println(e));
						break;
					}
					System.out.println("Do you want to continue?");
					bookcon = sc.next();
				} while (bookcon.equalsIgnoreCase("yes"));
				break;
			}
			if (bookcon.equalsIgnoreCase("done")) {
				System.out.println("Do you want to continue?");
				con = sc.next();
			} else {
				System.out.println("Press 1 for Main Menu and 0 For Exit!");
				con = sc.next();
			}

		} while (con.equalsIgnoreCase("yes") || con.equalsIgnoreCase("1"));
		if (con.equalsIgnoreCase("0") || con.equalsIgnoreCase("no")) {
			System.out.println("Thank You!");
		}
	}
}
