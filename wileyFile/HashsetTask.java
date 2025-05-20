package Collections;

import java.util.HashSet;
import java.util.Scanner;

class Book {
	
	int id;
	String name, author, publisher;
	int quantity;
	
	public Book(int id, String name, String author, String publisher, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}
}

public class HashsetTask {
	private static void printDetails(HashSet<Book> set) {
		// TODO Auto-generated method stub
		for (Book book : set) {
			System.out.println(book.id);
			System.out.println(book.name);
			System.out.println(book.author);
			System.out.println(book.publisher);
			System.out.println(book.quantity);
		}
		
	}
	
	private static void printBookWithMorethanFourCopies(HashSet<Book> set) {
		// TODO Auto-generated method stub
		for (Book book : set) {
			if (book.quantity > 4) {
				System.out.println(book.name);
			}
		}
		
	}
	
	private static String printBookPublishedByWiley(HashSet<Book> set) {
		// TODO Auto-generated method stub
		String publishedByWiley = "No";
		for (Book book : set) {
			if (book.publisher.equalsIgnoreCase("wiley")) {
				publishedByWiley = "yes";
				break;
			}
 		}
		return publishedByWiley;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		HashSet<Book> set = new HashSet<>();
		for (int i = 0; i < 2; i++) {
			int id = Integer.parseInt(sc.nextLine());
			String name = sc.nextLine();
			String auth = sc.nextLine();
			String publ = sc.nextLine();
			int qty = Integer.parseInt(sc.nextLine());
			Book b = new Book(id, name, auth, publ, qty);
			set.add(b);
		}
		printDetails(set);
		printBookWithMorethanFourCopies(set);
		System.out.println(printBookPublishedByWiley(set));
		sc.close();
	}
}
