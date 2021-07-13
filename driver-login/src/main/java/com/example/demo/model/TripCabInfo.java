package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "tripCabInformation")
public class TripCabInfo {

	@Id
	long tripCabId;
	String cabNumber;
	int driverID;
	String source;
	String destination;
	String dropPoint;

	LocalDate dateOfTravel;
	LocalTime timeSlot;
	int totalSeats;
	int remainingSeats;
	int allocatedSeats;
	LocalTime startTime;
	LocalTime endTime;

	String status;
	String createdBy;
	LocalDate createdDate;
	String modifiedBy;
	LocalDate modifiedDate;
	int isDeleted;
	
}
