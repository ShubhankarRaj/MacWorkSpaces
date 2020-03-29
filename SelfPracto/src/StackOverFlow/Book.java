package StackOverFlow;

import java.util.*;

class Book  {
	// this class can modified if necessary, including the class definition
	private String title;
	private String author;
	private double price;

	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

}

class Bookstore  {
	List<Book> books = new ArrayList<Book>();

	public Bookstore(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooksSortedByPrice(int order) {
		if(order==0){
			for(double outer=0; outer < books.size()-1; outer++)
			{
				for(double inner=outer; inner < books.size(); inner++)
				{
					if(Integer.toString((int) books.get((int) outer).getPrice()).compareTo(Integer.toString((int)books.get((int) inner).getPrice()))>0)  {  
						Book temp = books.get((int) outer);
						books.set((int) outer, books.get((int) inner));
						books.set((int) inner, temp);
					}
				}
			}}        

		if(order==1){
			for(double outer=0; outer < books.size()-1; outer++)
			{
				for(double inner=outer; inner < books.size(); inner++)
				{
					if(Integer.toString((int) books.get((int) outer).getPrice()).compareTo(Integer.toString((int) books.get((int) inner).getPrice()))<0)  {  
						Book temp = books.get((int) outer);
						books.set((int) outer, books.get((int) inner));
						books.set((int) inner, temp);
					}

				}
			}}        




		return books;
	}

	public List<Book> getBooksSortedByTitle(int order) {

		if(order==0){
			for(int outer=0; outer < books.size()-1; outer++)
			{
				for(int inner=outer; inner < books.size(); inner++)
				{
					if(books.get(outer).getTitle().compareTo(books.get(inner).getTitle())>0)  {  
						Book temp = books.get(outer);
						books.set(outer, books.get(inner));
						books.set(inner, temp);
					}

				}
			}}
		if(order==1){
			System.out.println("isu = ");
			for(int outer=0; outer < books.size()-1; outer++)
			{
				for(int inner=outer; inner < books.size(); inner++)
				{
					if(books.get(outer).getTitle().compareTo(books.get(inner).getTitle())<0)  {  
						Book temp = books.get(outer);
						books.set(outer, books.get(inner));
						books.set(inner, temp);
					}

				}
			}}        

		return books;
	}

	public List<Book> getBooksByAuthor(String author) {
		// this method returns the list of books for a given author
		// do not make any changes to this method
		// change the Book class to make sure this method will work correctly
		List<Book> result = new ArrayList<Book>();
		Book helperBook = new Book("Dummy", author, 0.0);
		for (Book b : books) {
			if (b.equals(helperBook)) {
				result.add(b);
			}
		}
		return result;
	}
}



