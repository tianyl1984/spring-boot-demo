package com.tianyl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tianyl.entity.City;

public interface CityRepository extends MongoRepository<City, String> {

}
