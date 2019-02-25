package com.qa.gogoGadgetMongoClientService.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.gogoGadgetMongoClientService.persistence.domain.SentReflectionForm;

@Repository
public interface MongoFormRepo extends MongoRepository<SentReflectionForm, Long> {

}
