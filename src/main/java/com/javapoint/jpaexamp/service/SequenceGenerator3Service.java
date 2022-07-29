package com.javapoint.jpaexamp.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.javapoint.jpaexamp.model.Book;
import com.javapoint.jpaexamp.model.Book3;
import com.javapoint.jpaexamp.model.DatabaseSequence3;

@Service
public class SequenceGenerator3Service {

//	
//	@Autowired

	
	private MongoOperations mongoOperations;
	
	
	

	public SequenceGenerator3Service(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;

	}

	public long generateSequence3(String seqName) {

		DatabaseSequence3 counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), DatabaseSequence3.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}
	
	
	
//
//	@Query("{'bookPrice': ?#{[0]} }")
//	  public List<Book3> findByBookPrice(String bookPrice){
//		return Books;
//	}
//	


//    @Override
    
	
//	public List<Book3> getCitiesByPrice() {
//		return book3;
//	}
//	
//	
//	
//    public List<Book3> findAllOrderByPriceAsc() {
//        return mongoOperations.findAllOrderByPriceAsc();
//    }

//    @Override
//    public List<Book3> findAllOrderByNameAsc() {
//
//        var sort = new Sort(Sort.Direction.ASC, "name");
//        return book3Repository.findAllOrderByNameAsc(sort);
//    }
//	
	
	
	
	

//	public List<Book3> findAll(String bookPrice, Sort sort) {
//		return Book3Repository(bookPrice, sort);
//	}

//	public List<Book3> findAll() {
//        return .findAll(orderByIdAsc());
//    }
//
//	private Sort orderByIdAsc() {
//		return new Sort(Sort.Direction.ASC, "id");
//
//}
}
