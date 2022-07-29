package com.javapoint.jpaexamp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javapoint.jpaexamp.model.ApiResponse;
import com.javapoint.jpaexamp.model.userRecord;
import com.javapoint.jpaexamp.service.UserService;



@RestController
@RequestMapping("/")
@Validated
public class UserController {
	@Autowired

	private UserService userService;

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<userRecord> getAllUser() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "add-user", method = RequestMethod.POST)
	public ApiResponse addUser(@RequestBody @Valid userRecord userRecord) {
		userService.addUser(userRecord);
		return new ApiResponse("add user record");

//		@RequestMapping(value = "add-user", method = RequestMethod.POST)
//		userRecord<String> addUser(@Validated @RequestBody userRecord userRecord) {
//		        // persisting the user
//		        return userRecord("User is valid");
//		    }	
//		
		
	}
	
	 @PutMapping("users/{id}")
	  public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody userRecord user) {
	   boolean updated = userService.updateUserById(id, user);  // finds the user with the provided id and update it
	   if(updated)
	    return new ResponseEntity<>(new ApiResponse("User updated."), HttpStatus.OK);
	   else
		   return new ResponseEntity<>(new ApiResponse("User not found."), HttpStatus.BAD_REQUEST);
	  }

	 
	 @DeleteMapping("users/{id}")
	 public ResponseEntity<?> deleteusers(@PathVariable int id ){
		 boolean isRemoved = userService.delete(id);
		 if(!isRemoved)
			 return new ResponseEntity<>(new ApiResponse("user not found."),HttpStatus.BAD_REQUEST); 
		 else
			 return new ResponseEntity<>(new ApiResponse("User Deleted."), HttpStatus.OK);
			
			 
	 }

}
