package com.javapoint.jpaexamp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javapoint.jpaexamp.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

}
