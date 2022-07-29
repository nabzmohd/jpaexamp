//package com.javapoint.jpaexamp.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.javapoint.jpaexamp.model.User;
//import com.javapoint.jpaexamp.repository.UserRepository;
//
//@RestController
//@RequestMapping(value = "/")
//public class User2Controller {
//
//	private final Logger LOG = LoggerFactory.getLogger(getClass());
//	private final UserRepository userRepository;
//
//	public User2Controller(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public List<User> getAllUsers() {
//		LOG.info("getting all users.");
//		return userRepository.findAll();
//
//	}
//
//	@GetMapping("/{userId}")
//	public User getUser(@PathVariable String userId) {
//		LOG.info("Getting user with ID: {}.", userId);
//		return userRepository.findOne(userId);
//	}
//
//	@RequestMapping(value = "/create",method = RequestMethod.POST)
//	public User addNewUsers(@RequestBody User user) {
//		LOG.info("Saving User.");
//		return userRepository.save(user);
//	}
//
//	@RequestMapping(value = "/settings/{userId}",method=RequestMethod.GET)
//	public Object getAllUserSetting(@PathVariable String userId) {
//		User user = userRepository.findOne(userId);
//		if(user !=null) {
//			return user.getUserSettings();
//		}else {
//			return "user is not found";
//		}
//	}
//
//	@RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
//	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
//		User user = userRepository.findOne(userId);
//		if (user != null) {
//			return user.getUserSettings().get(key);
//		} else {
//			return "User not found.";
//		}
//	}
//	
//	@RequestMapping(value = "/settings/{userId}/{key}/{value}",method =RequestMethod.GET)
//	public String addUserSettind(@PathVariable String userId,@PathVariable String Key,@PathVariable String value) {
//		User user = userRepository.findOne(userId);
//		if(user != null) {
//			user.getUserSettings().put(Key, value);
//			userRepository.save(user);
//			return "Key added";
//		}
//		else {
//			return "user not found";
//		}
//	}
//	
//		
//	}
//
//
