package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.TripCabInfo;



public interface TripCabInfoRepository extends MongoRepository<TripCabInfo, Long> {


	List<TripCabInfo> findTripDetailsByTripCabId(long tripCabId);
	
	
	Optional<TripCabInfo> findByCabNumber(String cabNumber);
	
	
}
