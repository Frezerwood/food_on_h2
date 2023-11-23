package com.startup.food.controller;

import com.startup.food.model.Food;
import com.startup.food.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/home")
    public String addFood(Model model, Food food) {
        if (food.getPrice() > 1000) {
            model.addAttribute("errorMessage", String.format("Could not add %s that is too expensive ", food.getName()));
        } else if (foodService.addFood(food) < 1) {
            model.addAttribute("errorMessage", String.format("Could not add %s", food.getName()));
        } else {
            model.addAttribute("successMessage", String.format("Successfully added the food %s", food.getName()));
        }

        Food[] foods = foodService.getFoods();
        model.addAttribute("foods", foods);
        return "home";
    }

    @GetMapping("/home")
    public String getHome(Model model, Food food) {

        model.addAttribute("message", "Hello! I am from the FoodController");

        Food[] foods = foodService.getFoods();

        model.addAttribute("foods", foods);

        return "home";
    }
}
