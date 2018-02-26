package com.example.dill.app.domain.dishes;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DishRepository extends MongoRepository<Dish, String> {

    public Dish findByName(String type);
    public List<Dish> findByType(String name);
    public Dish findById(String id);

}
