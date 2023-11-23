package com.startup.food.service;

import com.startup.food.model.Food;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class FoodService {

    public Food[] getFoods() {

        Food[] foods = {new Food("Burrito", 20.3), new Food("Pizza", 10.5), new Food("Apple", 2.0)};

        return foods;
    }
}
