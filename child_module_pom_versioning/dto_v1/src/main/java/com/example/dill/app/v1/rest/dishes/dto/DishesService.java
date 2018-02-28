package com.example.dill.app.v1.rest.dishes.dto;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dill.app.v1.rest.dishes.dto.DishDto;

@Service
public interface DishesService {

	DishDto createDish(DishDto dto);
	List<DishDto> getAllDishes();
	DishDto getDish(String id);
}
