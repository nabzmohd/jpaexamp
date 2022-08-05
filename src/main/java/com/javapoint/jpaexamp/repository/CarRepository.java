package com.javapoint.jpaexamp.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.javapoint.jpaexamp.model.Car;


@Repository
public interface CarRepository extends MongoRepository<Car, Long>,CarRepositorycustom {


	
	@Query("{company:?0}")
	public List<Car> findAll(String cpny);
	

	@Query("{company:?0}")
	public List<Car> findAll(String cpny, Sort sort);

	@Query("{year : {$lte : ?0}}") 
	public List<Car> findAllles(int lessyr);
    
    
    @Query("{year : {$gte :?0}}")
	public List<Car> findAllgtr(int gtyr);

   @Query("{year : {$gte :?1, $lte :?0}}")
	public List<Car> findAllbtyear(int less, int gtt);

	@Query("{year : {$lte : ?0}}") 
public List<Car> findAlllethan(int lesthan);

	 @Query("{year : {$gte :?0}}")
	public List<Car> findallgrater(int graterthan);

	 @Query("{year : {$gte :?1, $lte :?0}}")
	public List<Car> findbt(int lesthan, int graterthan);

	@Query ("{\"carprice\": {$lte : ?0}}")
	public List<Car> lescarprice(int lessThanprice);



	@Query ("{\"carprice\": {$gte : ?0}}")
	public List<Car> gateprice(int graterThanprice);

	@Query("{\"carprice\" : {$gte :?1, $lte :?0}}")
	public List<Car> betw(int lessThanprice, int graterThanprice);

    
	@Query("{year:?0}")
	public List<Car> findoneyr(int findyr);


	



	
	
	
	
//   @Query("{year : {$gte :?0, $lte :?0}}")
//public List<Car> findallyr( int lesthan, int graterthan);


   
//
//   @Query("{year : {$gte :2010 , $lte :2017}}")
//public List<Car> getAllyear(int lessthan, int graterthan);


	
	

}

