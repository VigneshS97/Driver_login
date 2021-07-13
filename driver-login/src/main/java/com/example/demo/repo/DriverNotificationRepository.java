package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TripCabInfo;



@Repository
public interface DriverNotificationRepository extends MongoRepository<TripCabInfo, String> {

		@Query(value="{cabNumber:?0,status:{$nin:[Completed]}}")
		TripCabInfo getTripAssignedDetailsByCabNumber(String cabNumber);
		
}