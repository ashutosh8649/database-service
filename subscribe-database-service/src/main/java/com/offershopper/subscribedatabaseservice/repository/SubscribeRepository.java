package com.offershopper.subscribedatabaseservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.offershopper.subscribedatabaseservice.model.SubscribeBean;

public interface SubscribeRepository extends MongoRepository<SubscribeBean, Integer>{

}
