package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.restaurant.dto.FoodItemDTO;
import com.restaurant.dto.RestaurantDTO;
import com.restaurant.entity.FoodItem;
import com.restaurant.entity.Restaurant;
import com.restaurant.service.FoodItemService;
import com.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private FoodItemService foodItemService;

    // ADMIN can add restaurant
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Restaurant addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.addRestaurant(restaurantDTO);
    }

    // USER + ADMIN can view restaurants
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Page<Restaurant> getAllRestaurants(
            @RequestParam int page,
            @RequestParam int size) {

        return restaurantService.getAllRestaurants(page, size);
    }

    // ADMIN can add food item
    @PostMapping("/{restaurantId}/fooditems")
    @PreAuthorize("hasRole('ADMIN')")
    public FoodItem addFoodItem(
            @PathVariable Long restaurantId,
            @RequestBody FoodItemDTO foodItemDTO) {

        return foodItemService.addFoodItem(restaurantId, foodItemDTO);
    }

    // USER + ADMIN can view food items
    @GetMapping("/{restaurantId}/fooditems")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<FoodItem> getFoodItems(@PathVariable Long restaurantId) {

        return foodItemService.getFoodItemsByRestaurant(restaurantId);
    }
}