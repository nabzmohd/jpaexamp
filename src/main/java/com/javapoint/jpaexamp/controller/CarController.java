package com.javapoint.jpaexamp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.callback.LanguageCallback;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javapoint.jpaexamp.exception.ResourceNotFoundException;
import com.javapoint.jpaexamp.model.Car;
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
//	@GetMapping("/carsss")
//	public List<Car> getAllCar(){
//		return carRepository.findAll();
//	}	

	
	
	
	// company filter and sorting
	@GetMapping("/cars")
	public List<Car> getAllcar(@RequestParam(name = "sortTypes", required = false, defaultValue = "0") int sortTypes,
			@RequestParam(name = "cpny", required = false, defaultValue = "") String cpny) {
		List<Car> res = carService.getAllcar(sortTypes, cpny);
		return res;
	}
	
	
	// year filtering lessthan,graterthan,between
	@GetMapping("/caryear")
	public List<Car> getallcaryear(@RequestParam(name ="filter" ,required = false, defaultValue = "0") int filter,
			@RequestParam(name = "lessThanYear", required = false, defaultValue = "0") int lesthan,
			@RequestParam(name = "graterThanYear", required = false, defaultValue = "0") int graterThanYear,
			@RequestParam(name = "findyr",required = false,defaultValue = "0")int findyr){
		//filter =0 => default
		//filter =1 => less than year
		//filter = 2 => greater than a year
		//filter =3 => between two years
		List<Car> check = carService.getallyr(filter ,lesthan ,graterThanYear,findyr);
		return check;
	}
	
	
	// car price fiter lessthan,graterthan,between
	@GetMapping("/carprice")
	public List<Car> getcarprice(@RequestParam (name = "type" ,required = false, defaultValue = "0")int type,
			@RequestParam(name ="lessThanprice" , required = false, defaultValue = "0")int lessThanprice,
			@RequestParam(name ="graterThanprice" , required = false , defaultValue =  "0")int graterThanprice){
		List<Car> price = carService.getprice(type ,lessThanprice ,graterThanprice);
		return price;
		
	}
	
	
	
	//car lesthan yr
	@GetMapping("/carles")
	public List<Car> getAllcar(@RequestParam(name = "lessyr", required = false, defaultValue = "0") int lessyr) {
		List<Car> les = carService.getAllles(lessyr);
		return les;
	}
	
	//car graterthan year
	@GetMapping("/cargtyr")
	public List<Car> getAllcars(@RequestParam(name = "gtyr", required = false, defaultValue = "0") int gtyr) {
		List<Car> gat = carService.getAllgtyr(gtyr);
		return gat;
	}
    
	// car between year
	@GetMapping("/carbt")
	public List<Car> getAllcars(@RequestParam(name = "less", required = false, defaultValue = "0") int less,
			@RequestParam(name = "gtt", required = false, defaultValue = "0") int gtt) {
		List<Car> legt = carService.getAllbtyear(less, gtt);
		return legt;
	}

	

	//pagable method one
//	@GetMapping("/carss")
//	public Page<Car> listofcarpaginated(Pageable p){
//		return carRepository.findall(p);
//	}

		
	// pagable method 2
	@GetMapping("/carspage")
	public Page<Car> getallcar(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
			throws ResourceNotFoundException {
		if (page < -1) {
			throw new ResourceNotFoundException("page index start zero");
		}
		if (size < 0) {
			throw new ResourceNotFoundException("size index start one");
		}
		return carRepository.findAll(PageRequest.of(page, size));
	}
	
	
	// request header method 1
//	@GetMapping("/test")
//	public String createuser(@RequestHeader String accept) { 
//		System.out.println("print the header");
//	return "success";
//	}
	
	// request header method 2
	@GetMapping("/head")
	public Car createuser(@RequestHeader(name = "abc") String sh, @RequestBody Car c) { 
		System.out.println("print the header");
	return carService.createuserr(sh,c);
	}
	
	
	
////	// putmapping method 1
//	@PutMapping("/cars/{id}")
//	public ResponseEntity<Car> updatecars(@PathVariable(value = "id") Long carId, @Valid @RequestBody Car carDetails)
//			throws ResourceNotFoundException {
//		Car updatecar = carService.updatecar(carId, carDetails);
//		return ResponseEntity.ok(updatecar);
//	}
	
	
	 @PutMapping("/carss/{id}")
	    public ResponseEntity < Car > updatecar(@PathVariable(value = "id") Long carId,  @RequestBody Car cardetails) 
	      throws ResourceNotFoundException {     
	        Car updatedcars = carService.updatec(carId,cardetails);
	        return ResponseEntity.ok(updatedcars);
	    }
	
//	@PutMapping("cars/{id}")
//	public Car update(@RequestBody Car car,@PathVariable(value = "id")Long carId) {
//		return carService.update(car);
//	}

	

	 // detemapping method 1
	@DeleteMapping("/cars/{id}")
	public Map<String, Boolean> deletecar(@PathVariable(value = "id") Long carId) 
			throws ResourceNotFoundException {
		carService.findById(carId);		
		return null;

	}
	
	
//	@DeleteMapping("/{deptId}")
//    public Car deleteDept(@PathVariable Long carId) {
//        carService.deleteById(carId);
//        
//        
//    }
	
//	public void deleteGroceryItem(Long carId) {
//        carService.deleteById(carId);
//        System.out.println("Item with id " + carId + " deleted...");
//    }
//	
	
	 // detemapping method 2
//	@DeleteMapping("/{deptId}")
//    public Long deleteDept(@PathVariable Long id) {
//        carRepository.deleteById(id);
//        return id;
//    }
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
//	
//	@PostMapping("/uploadFile")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
//        String fileName = carService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse(fileName,file.getSize());
//    }
//
//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

	
	
	

	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	
	
	
	
	
	
	
	



//	@PostMapping("/cars")
//	public Car createCar(@Valid @RequestBody Car car) {
////		car.setId(carSequenceGeneratorService.generateSequence4(Car.SEQUENCE_NAME));
//		return carRepository.save(car);
//	}
	
	
	

//	@PostMapping("/cars")
//	public String createCar(@Valid @RequestBody Car car) {
////		car.setId(carSequenceGeneratorService.generateSequence4(Car.SEQUENCE_NAME));
//		carRepository.save(car);
//		return "Cars record inserted";
//	}

}
