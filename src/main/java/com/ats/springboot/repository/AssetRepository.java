package com.ats.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ats.springboot.model.Asset;

public interface AssetRepository extends MongoRepository<Asset, String>{
	

}
