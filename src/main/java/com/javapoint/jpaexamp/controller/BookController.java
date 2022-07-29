package com.javapoint.jpaexamp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javapoint.jpaexamp.model.ApiResponse;
import com.javapoint.jpaexamp.model.Book;
import com.javapoint.jpaexamp.service.BookService;




@RestController
@RequestMapping("/")
@Validated

public class BookController {
	
	
	@Autowired

	private BookService bookService;
	
	
	@RequestMapping(value = "books", method = RequestMethod.GET)
	public List<Book> getAllbooks() {
		return bookService.getAllbooks();
	}
	
	@RequestMapping(value = "books", method = RequestMethod.POST)
	public ApiResponse addbook(@RequestBody @Valid Book Book) {
		bookService.addbook(Book);
		return new ApiResponse("add user record");
	}
	
	
	@PutMapping("books/{id}")
	  public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody Book book) {
	   boolean updated = bookService.updateBookById(id, book);  // finds the user with the provided id and update it
	   if(updated)
	    return new ResponseEntity<>(new ApiResponse("User updated."), HttpStatus.OK);
	   else
		   return new ResponseEntity<>(new ApiResponse("User not found."), HttpStatus.BAD_REQUEST);
	  }

	 
	 @DeleteMapping("books/{id}")
	 public ResponseEntity<?> deleteBook(@PathVariable int id ){
		 boolean isRemoved = bookService.delete(id);
		 if(!isRemoved)
			 return new ResponseEntity<>(new ApiResponse("user not found."),HttpStatus.BAD_REQUEST); 
		 else
			 return new ResponseEntity<>(new ApiResponse("User Deleted."), HttpStatus.OK);
			
			 
	 }
}
