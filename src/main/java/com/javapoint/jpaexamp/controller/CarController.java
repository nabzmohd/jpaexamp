package com.javapoint.jpaexamp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javapoint.jpaexamp.exception.ResourceNotFoundException;
import com.javapoint.jpaexamp.model.Car;
import com.javapoint.jpaexamp.repository.CarRepository;

@RestController
@RequestMapping("/")
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
//	@Autowired 
//	private CarSequenceGeneratorService carSequenceGeneratorService;
	
	
//
//	@GetMapping("/cars")
//	public List<Car> getAllCar(){
//		return carRepository.findAll();
//	}	
	
	
	@GetMapping("/cars")
	public List<Car> getAllcar(@RequestParam(name ="sortTypes" , required = false, defaultValue = "0")int sortTypes,
			@RequestParam(name = "cpny" ,required = false, defaultValue = "")String cpny){
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
	
	
//	@GetMapping("/carss")
//	public Page<Car> listofcarpaginated(Pageable p){
//		return carRepository.findall(p);
//	}
	
	@GetMapping("/carss")
	public Page<Car> listofcarpadinated(Pageable p){
		return carRepository.findAll(p);
	}
	
	
	
	
	
	
	
//	@PostMapping("/cars")
//	public Car createCar(@Valid @RequestBody Car car) {
////		car.setId(carSequenceGeneratorService.generateSequence4(Car.SEQUENCE_NAME));
//		return carRepository.save(car);
//	}
	
	
	@PostMapping("/cars")
	public String createCar(@Valid @RequestBody Car car) {
//		car.setId(carSequenceGeneratorService.generateSequence4(Car.SEQUENCE_NAME));
		carRepository.save(car);
		return "Cars record inserted";
	}
	
	
	
	
	@PutMapping("/cars/{id}")
	public ResponseEntity<Car> updatecars(@PathVariable(value = "id")Long carId,		
			@Valid @RequestBody Car carDetails)throws ResourceNotFoundException{
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("car not found thid id::"+carId));
		car.setCompany(carDetails.getCompany());
		car.setCarname(carDetails.getCarname());
		car.setCarprice(carDetails.getCarprice());
		car.setCarmodel(carDetails.getCarmodel());
		car.setYear(carDetails.getYear());
		final Car updatedcars = carRepository.save(car);
		return ResponseEntity.ok(updatedcars);
	}
	
	@DeleteMapping("/cars/{id}")
	public Map<String, Boolean> deletecar(@PathVariable (value = "id")Long carId)
	throws ResourceNotFoundException{
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("cars not found this id ::" +carId));
		carRepository.delete(car);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
				
	}
	
	
	
	
	
	
	
	
	
}
