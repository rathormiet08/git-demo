package com.lambda;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
	private static List<Book> books;
	static {
		books=new ArrayList<>();
		books.add(new Book(1, "java", 200));
		books.add(new Book(2, "spring", 150));
		books.add(new Book(3, "hibernate", 300));
		books.add(new Book(4, "html", 100));
		books.add(new Book(5, "abcd", 600));
	}
	
public static List<Book> getBooks(){
		return books;
	}
}
