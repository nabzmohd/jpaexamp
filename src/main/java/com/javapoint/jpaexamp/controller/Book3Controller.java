package com.javapoint.jpaexamp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javapoint.jpaexamp.exception.ResourceNotFoundException;
import com.javapoint.jpaexamp.model.Book3;
import com.javapoint.jpaexamp.repository.Book3Repository;
import com.javapoint.jpaexamp.service.SequenceGenerator3Service;

@RestController
public class Book3Controller {

	@Autowired
	private Book3Repository book3Repository;

	@Autowired
	private SequenceGenerator3Service sequenceGenerator3Service;


	@GetMapping("/book3/{id}")
	public ResponseEntity<Book3> getBookById(@PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
		Book3 book3 = book3Repository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for thid id : : " + bookId));
		return ResponseEntity.ok().body(book3);
	}

	@GetMapping("/book3")
	public List<Book3> getAllBooks(@RequestParam(name = "sortType", required = false, defaultValue = "0") int sortType,
			@RequestParam(name = "author", required = false, defaultValue = "") String author) {
		if (sortType == 0 && author.equals("")) {
			return book3Repository.findAll();
		}
		if (sortType == 0 && !author.equals("")) {
			return book3Repository.findAll(author);
		}
		
		
		Sort sort = null;
		switch (sortType) {
		case 1:
			sort = Sort.by(Direction.ASC, "bookPrice");
			break;
		case 2:
			sort = Sort.by(Direction.DESC, "bookPrice");
			break;
		case 3:
			sort = Sort.by(Direction.ASC, "creationDate");
			break;
		case 4:
			sort = Sort.by(Direction.DESC, "creationDate");
			break;
		default:
			sort = Sort.by(Direction.ASC, "bookPrice");
			break;
		}
		if (sortType != 0 && author.equals("")) {
			return book3Repository.findAll(sort);
		}
//		if (sortType != 0 && !author.equals("")) {
		return book3Repository.findAll(author, sort);
//			}

	}


	
	
	
	
	

	@PostMapping("/book3")
	public Book3 createBook(@Valid @RequestBody Book3 book3) {
		book3.setId(sequenceGenerator3Service.generateSequence3(Book3.SEQUENCE_NAME));
		return book3Repository.save(book3);
	}

	@PutMapping("/book3/{id}")
	public ResponseEntity<Book3> updatebook3(@PathVariable(value = "id") Long bookId,
			@Valid @RequestBody Book3 book3Details) throws ResourceNotFoundException {
		Book3 book3 = book3Repository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found this id :: " + bookId));

		book3.setBookName(book3Details.getBookName());
		book3.setBookPrice(book3Details.getBookPrice());
		book3.setAuthername(book3Details.getAuthername());
		book3.setCreationDate(book3Details.getCreationDate());
		final Book3 updatebook3 = book3Repository.save(book3);
		return ResponseEntity.ok(updatebook3);

	}

	@DeleteMapping("/book3/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long bookId)
			throws ResourceNotFoundException {
		Book3 book3 = book3Repository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("book not found this id ::" + bookId));

		book3Repository.delete(book3);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
