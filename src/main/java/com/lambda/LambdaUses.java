package com.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaUses {

	private static List<Book> books;

	public static void main(String[] args) {
		List<Book> bookWithSortByName = getBookWithSortByName(books);
		
		System.out.println(bookWithSortByName);
	}

	private static List<Book> getBookWithSortByName(List<Book> books) {
		
		List<Book> list = BookDao.getBooks();
		Collections.sort(list,(o1,o2)->o1.getPage()-o2.getPage() );
		return list;
	}

}

class BookSortByName implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

