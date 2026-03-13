package com.restaurant.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.FoodItemDTO;
import com.restaurant.entity.FoodItem;
import com.restaurant.repository.FoodItemRepository;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FoodItem addFoodItem(Long restaurantId, FoodItemDTO foodItemDTO) {

        FoodItem foodItem = modelMapper.map(foodItemDTO, FoodItem.class);

        foodItem.setRestaurantId(restaurantId);

        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> getFoodItemsByRestaurant(Long restaurantId) {

        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}