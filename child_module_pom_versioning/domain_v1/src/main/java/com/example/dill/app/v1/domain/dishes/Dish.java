package com.example.dill.app.v1.domain.dishes;

import org.springframework.data.annotation.Id;

public class Dish{

    @Id
    public String id;

    public String type;
    public String name;

    public Dish() {}

    public Dish(String type, String name) {
        this.type = type;
        this.name = name;
    }

    
    
	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	@Override
    public String toString() {
        return String.format(
                "Dish[id=%s, type='%s', name='%s']",
                id, type, name);
    }
}
