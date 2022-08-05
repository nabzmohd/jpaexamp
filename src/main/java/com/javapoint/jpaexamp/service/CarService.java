package com.javapoint.jpaexamp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.javapoint.jpaexamp.exception.ResourceNotFoundException;
import com.javapoint.jpaexamp.model.Car;
import com.javapoint.jpaexamp.repository.CarRepository;
import com.javapoint.jpaexamp.repository.CarRepositorycustom;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	
	
	
//	private final Path fileStorageLocation;
	
	
	
	
//car price and year with accenting  and desenting   order //
	
	public List<Car> getAllcar(int sortTypes, String cpny) {
		if (sortTypes == 0 && cpny.equals("")) {
			return carRepository.findAll();
		}
		if (sortTypes == 0 && !cpny.equals("")) {
			return carRepository.findAll(cpny);
		}

		Sort sort = null;
		switch (sortTypes) {
		case 1:
			sort = Sort.by(Direction.ASC, "carprice");
			break;
		case 2:
			sort = Sort.by(Direction.DESC, "carprice");
			break;
		case 3:
			sort = Sort.by(Direction.ASC, "year");
			break;
		case 4:
			sort = Sort.by(Direction.DESC, "year");
			break;
		default:
			sort = Sort.by(Direction.ASC, "carprice");
			break;
		}
		if (sortTypes != 0 && cpny.equals("")) {
			return carRepository.findAll(sort);
		}

		return carRepository.findAll(cpny, sort);
		
		
		
		
		
		
		
	}
	
	
	
	
	
	public List<Car> getyears(int filteryr, List<Integer> findyear) {
		switch (filteryr) {
		case 1:
			return carRepository.findyer(findyear);
		default:
			break;
		}
	
		return carRepository.findAll();
	}
	
	

	
	
	//year lessthan graterthan between//
	
	public List<Car> getallyr(int filter, int lessthan, int graterThanYear,int findyr) {

		System.out.println("filter " + filter);
		System.out.println("lessthan " + lessthan);
		System.out.println("graterthan " + graterThanYear);
		System.out.println("=================");
		switch (filter) {
		case 1:
			if (lessthan <= 0) {
				throw new ResourceNotFoundException("lessThanYear required");
			}
			return carRepository.findAlllethan(lessthan);
		case 2:
			if (graterThanYear <=0) {
				throw new ResourceNotFoundException("graterThanYear required");
			}
			return carRepository.findallgrater(graterThanYear);
		case 3:
			if (lessthan <= 0 || graterThanYear < 2000) {
				throw new ResourceNotFoundException("lessThanYear, graterThanYear required");
			}
			return carRepository.findbt(lessthan, graterThanYear);
		case 4:
			if(findyr <= 0) {
				throw new ResourceNotFoundException("Year not found");
			}
			return carRepository.findoneyr(findyr);
		default:
			break;
		}

//		if (filter == 1) {
//			if (lessthan <= 0) {
//				throw new ResourceNotFoundException("lessThanYear required");
//			}
//			return carRepository.findAlllethan(lessthan);
//		}
//		if (filter == 2) {
//			if (graterThanYear < 2000) {
//				throw new ResourceNotFoundException("graterThanYear required");
//			}
//			return carRepository.findallgrater(graterThanYear);
//		}
//		if (filter == 3) {
//			if (lessthan <= 0 || graterThanYear < 2000) {
//				throw new ResourceNotFoundException("lessThanYear, graterThanYear required");
//			}
//
//			return carRepository.findbt(lessthan, graterThanYear);
//		}
//			

		return carRepository.findAll();
	}
	
	
	
	
	
	//year lessthan graterthan between// method 2
	public List<Car> getAllles(int lessyr) {
		return carRepository.findAllles(lessyr);
	}

	public List<Car> getAllgtyr(int gtyr) {
		return carRepository.findAllgtr(gtyr);
	}

	public List<Car> getAllbtyear(int less, int gtt) {
		return carRepository.findAllbtyear(less, gtt);

	}
	
	
	
	
	//price lessthan graterthan between
	
	public List<Car> getprice(int type, int lessThanprice, int graterThanprice) {
		switch (type) {
		case 1:
			if(lessThanprice <=0) {
				throw new ResourceNotFoundException("lessthan price require");
			}	
				return carRepository.lescarprice(lessThanprice);
		case 2:	
			
				if(graterThanprice <=0) {
					throw new ResourceNotFoundException("graterthan price require");
				}
				return carRepository.gateprice(graterThanprice);
			
		case 3:		
			
				if(lessThanprice <=0 || graterThanprice <=0) {
					throw new ResourceNotFoundException("lessprice ,graterthan price require");
				}
				return carRepository.betw(lessThanprice,graterThanprice);
			
		default:
			break;
			}
			
			return carRepository.findAll();
		
		
		
		
//		
//		System.out.println("type "+type);
//		if(type == 1) {
//			if(lessThanprice <=0) {
//				throw new ResourceNotFoundException("lessthan price require");
//			}	
//				return carRepository.lescarprice(lessThanprice);
//		}
//		if(type == 2) {
//			if(graterThanprice <=0) {
//				throw new ResourceNotFoundException("graterthan price require");
//			}
//			return carRepository.gateprice(graterThanprice);
//		}
//		if(type == 3) {
//			if(lessThanprice <=0 || graterThanprice <=0) {
//				throw new ResourceNotFoundException("lessprice ,graterthan price require");
//			}
//			return carRepository.betw(lessThanprice,graterThanprice);
//		}	
//		return carRepository.findAll();
	
	}
	
	
	
	
	
	

	
	
	public Car createuserr(String sh,Car c) {
		if(sh.equals(c.getCarmodel())) {
			return c;
			
		}else {
			return new Car();
		}
	}
	
	
	
	
	
	

	

//	public Car updatecar(Long carId, @Valid Car carDetails) {
////		CarRepositorycustom.updateCar(carDetails, carId);
//		Car car = carRepository.findById(carId)
//				.orElseThrow(() -> new ResourceNotFoundException("car not found thid id::" + carId));
//		car.setCompany(carDetails.getCompany());
//		car.setCarname(carDetails.getCarname());
//		car.setCarprice(carDetails.getCarprice());
//		car.setCarmodel(carDetails.getCarmodel());
//		car.setYear(carDetails.getYear());
//		final Car updatedcars = carRepository.save(car);
//		return updatedcars;
//	}



	public Car updatec(Long carId, Car cardetails) {	
		carRepository.updateCar(cardetails ,carId);
//		 Car car = carRepository.findById(carId)
//		            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + carId));          
//		        car.setId(cardetails.getId());
//		        car.setCompany(cardetails.getCompany());
//		        car.setCarname(cardetails.getCarname());
//		        car.setCarprice(cardetails.getCarprice());
//		        car.setCarmodel(cardetails.getCarmodel());
//		        car.setYear(cardetails.getYear());	        
//				final Car updatecarss = carRepository.save(car);
		return null;
	}



	public Car findById(Long carId) {
//		carRepository.delete(carId);
		carRepository.deleteBy(carId);
//		.orElseThrow(() -> new ResourceNotFoundException("cars not found this id ::" + carId));
//		
//		carRepository.delete(car);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
		return null;
	}







	

	


	
	
//	public String storeFile(MultipartFile file) {
//        // Normalize file name
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        try {
//            // Check if the file's name contains invalid characters
//            if(fileName.contains("..")) {
//                throw new ResourceNotFoundException("Sorry! Filename contains invalid path sequence " + fileName);
//            }
//
//            // Copy file to the target location (Replacing existing file with the same name)
//            Path targetLocation = this.fileStorageLocation.resolve(fileName);
//            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//
//            return fileName;
//        } catch (IOException ex) {
//            throw new ResourceNotFoundException("Could not store file " + fileName + ". Please try again!"+ ex);
//        }
//    }
//	
	
	
	
	
	

	

}
