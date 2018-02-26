package com.example.dill.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.dill.app.exceptions.DishNotFoundException;
import com.example.dill.app.rest.dishes.dto.DishDto;
import com.example.dill.app.rest.dishes.dto.DishesService;

@RestController
@EnableWebMvc 
@RequestMapping("/dishes")
public class DishesController {

	@Autowired
	private DishesService dishesService;

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DishDto>> viewDishes() {
		List<DishDto> dishes = null;
		try{
    	dishes = dishesService.getAllDishes();
		}catch(DishNotFoundException e){
			//TODO logger to log errors
			return new ResponseEntity<List<DishDto>>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<List<DishDto>>(dishes, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<DishDto> viewDishe(@PathVariable String id) {
		DishDto dish = null;
		try{
			dish = dishesService.getDish(id);
		}catch(DishNotFoundException e){
			//TODO logger to log errors
			return new ResponseEntity<DishDto>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<DishDto>(dish, HttpStatus.OK);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DishDto> createDish(
    		@RequestBody DishDto dto) {
		
		DishDto dtoRes = dishesService.createDish(dto);
        return new ResponseEntity<DishDto>(dtoRes, HttpStatus.CREATED);
    }
}