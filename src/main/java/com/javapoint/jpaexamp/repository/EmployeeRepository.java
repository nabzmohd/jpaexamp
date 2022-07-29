package com.javapoint.jpaexamp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javapoint.jpaexamp.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}
