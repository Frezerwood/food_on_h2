package com.startup.food.controller;

import com.startup.food.model.Food;
import com.startup.food.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/home")
    public String getHome(Model model) {

        model.addAttribute("message", "Hello! I am from the FoodController");

        Food[] foods = foodService.getFoods();

        model.addAttribute("foods", foods);

        return "home";
    }
}
