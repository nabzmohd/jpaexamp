package com.javapoint.jpaexamp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.javapoint.jpaexamp.exception.ResourceNotFoundException;
import com.javapoint.jpaexamp.model.Car;
import com.javapoint.jpaexamp.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;

	public List<Car> getAllcar(int sortTypes, String cpny) {
		if(sortTypes == 0 && cpny.equals("")) {
			return carRepository.findAll();
		}
		if(sortTypes == 0 && !cpny.equals("")){
			return carRepository.findAll(cpny);
		}
		
		Sort sort = null;
		switch (sortTypes) {
		case 1:
			sort = Sort.by(Direction.ASC,"carprice");
			break;
		case 2:
			sort = Sort.by(Direction.DESC,"carprice");
			break;
		case 3:
			sort = Sort.by(Direction.ASC, "year");
			break;	
		case 4:
			sort = Sort.by(Direction.DESC, "year");
		    break;
		default:
			sort = Sort.by(Direction.ASC,"carprice");
			break;
		}
		if (sortTypes != 0 && cpny.equals("")) {
			return carRepository.findAll(sort);
		}
		return carRepository.findAll(cpny, sort);
	}

	public Car updatecar(Long carId, @Valid Car carDetails) {
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("car not found thid id::"+carId));
		car.setCompany(carDetails.getCompany());
		car.setCarname(carDetails.getCarname());
		car.setCarprice(carDetails.getCarprice());
		car.setCarmodel(carDetails.getCarmodel());
		car.setYear(carDetails.getYear());
		final Car updatedcars = carRepository.save(car);
		return updatedcars;
	}

}
