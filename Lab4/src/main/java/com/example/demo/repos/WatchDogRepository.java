package com.example.demo.repos;

import com.example.demo.jms.WatchDogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchDogRepository extends CrudRepository<WatchDogEntity, Integer> {
}
