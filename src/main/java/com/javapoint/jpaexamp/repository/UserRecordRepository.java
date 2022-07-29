package com.javapoint.jpaexamp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javapoint.jpaexamp.model.userRecord;

public interface UserRecordRepository  extends MongoRepository<userRecord, String>{

}
