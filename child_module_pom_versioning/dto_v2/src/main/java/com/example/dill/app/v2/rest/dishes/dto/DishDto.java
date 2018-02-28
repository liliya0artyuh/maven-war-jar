package com.example.dill.app.v2.rest.dishes.dto;

import java.io.Serializable;

public class DishDto implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2681612197034134220L;
	private String type;
    private String name;
    private String id;

    public DishDto() {}

    public DishDto(String type, String name) {
    	this.id = id;
        this.type = type;
        this.name = name;
    }
    
    public DishDto(String type, String name, String id) {
    	this.id = id;
        this.type = type;
        this.name = name;
    }

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
   
	public String getId() {
		return id;
	}
    
}
