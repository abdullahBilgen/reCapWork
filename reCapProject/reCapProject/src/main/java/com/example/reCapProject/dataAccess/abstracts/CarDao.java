package com.example.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.dtos.CarDetailDto;


public interface CarDao extends JpaRepository<Car, Integer> {

	@Query("Select new com.example.reCapProject.entities.dtos.CarDetailDto"	
			+ " (c.carName, b.brandName , col.colorName, c.dailyPrice) " 
			+ " From Brand b Inner Join b.cars c"
			+ " Inner Join c.color col")
	
	List<CarDetailDto> getCarWithDetails();

}
