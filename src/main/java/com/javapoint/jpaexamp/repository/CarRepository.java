package com.javapoint.jpaexamp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.javapoint.jpaexamp.model.Car;


@Repository
public interface CarRepository extends MongoRepository<Car, Long> {

	
	
	@Query("{company:?0}")
	public List<Car> findAll(String cpny);
	

	@Query("{company:?0}")
	public List<Car> findAll(String cpny, Sort sort);


	
	

}
