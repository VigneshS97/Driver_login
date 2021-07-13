package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminContacts;


@Repository
public interface AdminContactsRepository extends MongoRepository<AdminContacts, Integer> {

	

}
