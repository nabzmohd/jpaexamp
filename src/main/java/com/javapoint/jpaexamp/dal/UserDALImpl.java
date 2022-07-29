package com.javapoint.jpaexamp.dal;

import java.util.List;

//import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.javapoint.jpaexamp.model.User;

@Repository
public class UserDALImpl implements UserDAL {
	
	@Autowired 
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<User>getAllUsers(){
		return mongoTemplate.findAll(User.class);	
	}
	
	@Override 
	public User getUserById(String userId){
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, User.class);
	}
	@Override
	public User addNewUser(User user) {
		mongoTemplate.save(user);
		return user;	
	}
	public Object getAllUsersSetings(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null?
				user.getUserSettings():"User not found.";
	}
	@Override
	public String getUserSetting(String userId,String key) {
		Query query = new Query();
		query.fields().include("userSetting");
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("userSettings." + key).exists(true)));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null?
				user.getUserSettings().get(key) : "not found.";
	}
		@Override 
		public String addUserSetting(String userId, String key,String value) {
			Query query = new Query();
			query.addCriteria(Criteria.where("userId").is(userId));
			User user = mongoTemplate.findOne(query, User.class);
			if(user !=null) {
				user.getUserSettings().put(key, value);
				mongoTemplate.save(user);
				return "Key added.";
			}
			else {
				return "User not found.";
			}
		
	}

		@Override
		public Object getAllUserSeyyings(String userId) {
			// TODO Auto-generated method stub
			return null;
		}

}
