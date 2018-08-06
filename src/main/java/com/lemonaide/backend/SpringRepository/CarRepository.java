package com.lemonaide.backend.SpringRepository;

import com.lemonaide.backend.RedisRepository.Car;
import org.springframework.data.repository.CrudRepository;


public interface CarRepository extends CrudRepository<Car, String> {

}
