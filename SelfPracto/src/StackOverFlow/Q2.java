package StackOverFlow;

import java.util.ArrayList;
import java.util.List;

public class Q2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {



		List<Book> book = new ArrayList<Book>();

		book.add(new Book("Java Programming", "Joyce Farrell", 881.0));
		book.add( new Book("Team Of Rivals", "Dorris Kearns Goodwin", 994));
		book.add (new Book("1776", "Daivd McCullough", 400));
		book.add (new Book("No Ordinary Time", "Dorris Kearns Goodwin", 768));
		book.add( new Book("Steve Jobs", "Walter Isaacson", 656));

		book.add( new Book("Dummy","Walter",0.0));
		book.add( new Book("Dummy","Walter",0.0)); 
		Bookstore df=new Bookstore(book);


		List<Book> booksSorted = df.getBooksByAuthor("Walter");
		for (Book number : booksSorted) {




			System.out.println( number.getPrice()+"--as--"+number.getTitle()+"----"+number.getAuthor());



		}



	}
}