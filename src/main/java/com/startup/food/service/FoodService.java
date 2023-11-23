package com.startup.food.service;

import com.startup.food.mapper.FoodMapper;
import com.startup.food.model.Food;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class FoodService {

    FoodMapper foodMapper;

    public FoodService(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public int addFood(Food food) {
        return foodMapper.insertFood(food);
    }

    public Food[] getFoods() {

        //Food[] foods = {new Food("Burrito", 20.3), new Food("Pizza", 10.5), new Food("Apple", 2.0)};
        Food[] foods = foodMapper.selectFoods();

        return foods;
    }
}
