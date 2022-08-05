package com.javapoint.jpaexamp.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.javapoint.jpaexamp.model.Car;
import com.javapoint.jpaexamp.repository.CarRepositorycustom;

public class CarRepositoryImpl implements CarRepositorycustom{
@Autowired
private MongoTemplate mongoTemplate;

@Override
public void updateCar(Car car, Long carId) {
	
	 Query query = new Query();
   query.addCriteria(Criteria.where("id").is(car.getId()));
   Update update = new Update();
   update.set("company",car.getCompany());
   update.set("description", car.getCarname());
   update.set("description", car.getCarprice());
   update.set("description", car.getCarmodel());
   update.set("description", car.getYear());
   mongoTemplate.findAndModify(query, update, Car.class);
}

@Override
public void deleteBy(Long carId) {
	
	
    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(carId));
    mongoTemplate.remove(query, Car.class);
}



}



