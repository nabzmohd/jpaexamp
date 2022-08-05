package com.javapoint.jpaexamp.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.javapoint.jpaexamp.model.Car;

public interface CarRepositorycustom {

	@Autowired
	public void updateCar(Car car,Long carId) ;
	
	public void deleteBy(Long carId);
	
}
