package com.javapoint.jpaexamp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
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
import com.javapoint.jpaexamp.model.ApiResponse;
import com.javapoint.jpaexamp.model.Book;
import com.javapoint.jpaexamp.model.Car;
import com.javapoint.jpaexamp.model.userRecord;
import com.javapoint.jpaexamp.repository.CarRepository;
import com.javapoint.jpaexamp.service.CarService;

@RestController
@RequestMapping("/")
public class CarController {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarService carService;

//	@Autowired 
//	private CarSequenceGeneratorService carSequenceGeneratorService;

//
//	@GetMapping("/cars")
//	public List<Car> getAllCar(){
//		return carRepository.findAll();
//	}	

	@GetMapping("/cars")
	public List<Car> getAllcar(@RequestParam(name = "sortTypes", required = false, defaultValue = "0") int sortTypes,
			@RequestParam(name = "cpny", required = false, defaultValue = "") String cpny) {
		List<Car> res = carService.getAllcar(sortTypes, cpny);
		return res;
	}

//	@GetMapping("/carss")
//	public Page<Car> listofcarpaginated(Pageable p){
//		return carRepository.findall(p);
//	}

	@GetMapping("/carsss")
	public Page<Car> getallcar(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
			throws ResourceNotFoundException {
		if (page < -1) {
			throw new ResourceNotFoundException("page index start zero");
		}
		if (size < 0) {
			throw new ResourceNotFoundException("size index start zero");
		}
		return carRepository.findAll(PageRequest.of(page, size));
	}

	

	@PostMapping("/cars")
	public String createCar(@Valid @RequestBody Car car) {
//		car.setId(carSequenceGeneratorService.generateSequence4(Car.SEQUENCE_NAME));
		carRepository.save(car);
		return "Cars record inserted";
	}

	@PutMapping("/cars/{id}")
	public ResponseEntity<Car> updatecars(@PathVariable(value = "id") Long carId, @Valid @RequestBody Car carDetails)
			throws ResourceNotFoundException {
		Car updatecar = carService.updatecar(carId, carDetails);
		return ResponseEntity.ok(updatecar);
	}

	@DeleteMapping("/cars/{id}")
	public Map<String, Boolean> deletecar(@PathVariable(value = "id") Long carId) throws ResourceNotFoundException {
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("cars not found this id ::" + carId));
		carRepository.delete(car);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}
	
	
//	@GetMapping("/carss")
//	public Page<Car> listofcarpadinated(Pageable p){
//		return carRepository.findAll(p);
//	}

//	@PostMapping("/cars")
//	public Car createCar(@Valid @RequestBody Car car) {
////		car.setId(carSequenceGeneratorService.generateSequence4(Car.SEQUENCE_NAME));
//		return carRepository.save(car);
//	}


}
