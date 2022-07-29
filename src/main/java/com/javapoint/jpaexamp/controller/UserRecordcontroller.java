package com.javapoint.jpaexamp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javapoint.jpaexamp.model.ApiResponse;
import com.javapoint.jpaexamp.model.userRecord;
import com.javapoint.jpaexamp.service.UserService;

@RestController
public class UserRecordcontroller {

	@Autowired
	private UserService userService;


	@GetMapping("/user2")
	public List<userRecord> getAlluserRecord() {
//		model.addAllAttributes("user2");
//		return repository.findAll();
		return new ArrayList<>();
	}

	@PostMapping("/add-user2")
	public ApiResponse addUser(@RequestBody @Valid userRecord userRecord) {
//		repository.save(userRecord);
		return new ApiResponse("add user record");

	}
	
	  
	  
	  
	  @PutMapping("user2/{id}")
	  public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody userRecord user) {
		  userService.updateUserId(id, user);
//		  boolean updated = UserService.updateUserId(id , user);
//		  if(updated) {
		  return new ResponseEntity<>(new ApiResponse("User updated."), HttpStatus.OK);
//	  }
//	  else {
//		  return new ResponseEntity<>(new ApiResponse("User not found."), HttpStatus.BAD_REQUEST);
//	  }
	  
		  // finds the user with the provided id and update it
//	   if(updated)
//	    return new ResponseEntity<>(new ApiResponse("User updated."), HttpStatus.OK);
//	   else
//		   return new ResponseEntity<>(new ApiResponse("User not found."), HttpStatus.BAD_REQUEST);
//	  }
	  
	  
//	  @PutMapping("/user2/{id}")
//	    public userRecord updExpenses(@RequestBody userRecord user, @PathVariable int id){
//	        return repository.updateUserById(id, user);
//	        
//	}
//	  
	  
//	  @PutMapping("user2/{Iid}")
//	    public userRecord updateDept(@RequestBody userRecord user, @PathVariable int id) {
//	        userRecord.setId(id);
//	        userRecordRepository.save(userRecord);
//	        return new ApiResponse("user updated");
//	    }
	  
	    
	  
	  
//	  @DeleteMapping("user2/{id}")
//		 public ResponseEntity<?> deleteusers(@PathVariable int id ){
//			 boolean isRemoved = repository.delete(id);
//			 if(!isRemoved)
//				 return new ResponseEntity<>(new ApiResponse("user not found."),HttpStatus.BAD_REQUEST); 
//			 else
//				 return new ResponseEntity<>(new ApiResponse("User Deleted."), HttpStatus.OK);
//				
//				 
//		 }
	
	
	
	
	
	
	
	
	  }
	  }
