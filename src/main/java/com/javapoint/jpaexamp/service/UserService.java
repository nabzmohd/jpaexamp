package com.javapoint.jpaexamp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javapoint.jpaexamp.model.userRecord;

@Service
public class UserService {
	
	List<userRecord> userRecords = new ArrayList<>();
	public Object postService;

	public List<userRecord> getAllUsers() {
		return userRecords;
	}

	public void addUser(userRecord userRecord) {
		System.out.println(userRecord);
		userRecords.add(userRecord);

	}


	public boolean updateUserById(int id, userRecord user) {
		int index = finduserById(id);
		if (index == -1) {
			System.out.println("user not found");
//			throw new RuntimeException("user not found");
			return false;
		} else {
			userRecord userRecord = userRecords.get(index);
			userRecord.setEmail(user.getEmail());
			userRecord.setName(user.getName());
		}
		return true;
	}

	private int finduserById(int id) {
		int index = -1;
		Iterator<userRecord> iterator = userRecords.iterator();
		while (iterator.hasNext()) {
			userRecord userRecord = (userRecord) iterator.next();
			index += 1;
			if (userRecord.getId() == id) {
				return index;
			}
		}
		return -1;
	}

		
	public boolean delete( int id) {
		
		
		int index = finduserById(id);
		if (index == -1) {
			// TODO Auto-generated method stub
			System.out.println("user not found");
//			throw new RuntimeException("user not found");
			return false;
		} else {
				
			
//			userRecord userRecord = userRecords.get(index);
		     userRecords.remove(index);
			System.out.println("user Deleted");
			return true;
		}
		
	}

	public  boolean updateUserId(int id, userRecord user) {
		// TODO Auto-generated method stub
//		userRecord obj = new userRecord();
	
		System.out.println(id);
		System.out.println(user);
		return true;
	}	
}


