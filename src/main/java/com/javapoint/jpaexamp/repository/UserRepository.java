package com.javapoint.jpaexamp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javapoint.jpaexamp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


}
