package com.javapoint.jpaexamp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.javapoint.jpaexamp.model.Book;

@Service
public class BookService {
	
	
	List<Book> books = new ArrayList<>();
	public Object postService;
	
	
	

	public List<Book> getAllbooks() {
		return books;
	}

	public void addbook(Book Book) {
		System.out.println(Book);
		books.add(Book);

	}
	
	
	
	public boolean updateBookById(int id, Book book) {
		int index = finduserById(id);
		if (index == -1) {
			System.out.println("user not found");
			return false;
		} else {
			Book Book = books.get(index);
			Book.setBookName(book.getBookName());
			Book.setBookPrice(book.getBookPrice());
			Book.setAuthername(book.getAuthername());
			Book.setCreationDate(book.getCreationDate());
		}
		return true;
	}

	private int finduserById(int id) {
		int index = -1;
		Iterator<Book> iterator = books.iterator();
		while (iterator.hasNext()) {
			Book Book = (Book) iterator.next();
			index += 1;
			if (Book.getId() == id) {
				return index;
			}
		}
		return -1;
	}

		
	public boolean delete( int id) {
		
		
		int index = finduserById(id);
		if (index == -1) {
			System.out.println("user not found");
			return false;
		} else {
				
		     books.remove(index);
			System.out.println("user Deleted");
			return true;
		}
		
	}

}
