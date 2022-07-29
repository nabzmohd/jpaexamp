package com.javapoint.jpaexamp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.javapoint.jpaexamp.model.Book3;

@Repository
public interface Book3Repository extends MongoRepository<Book3, Long> {

	@Query("{authername:?0}")
	public List<Book3> findAll(String author);

	@Query("{authername:?0}")
	public List<Book3> findAll(String author, Sort sort);


}
