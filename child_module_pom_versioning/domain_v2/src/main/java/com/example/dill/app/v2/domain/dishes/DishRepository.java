package com.example.dill.app.v2.domain.dishes;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component("DishRepository_v2")
public interface DishRepository extends MongoRepository<Dish, String> {

    public Dish findByName(String type);
    public List<Dish> findByType(String name);
    public Dish findById(String id);

}
