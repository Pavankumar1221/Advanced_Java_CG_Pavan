package com.restaurant.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.restaurant.dto.RestaurantDTO;
import com.restaurant.entity.Restaurant;
import com.restaurant.exception.ResourceNotFoundException;
import com.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Restaurant addRestaurant(RestaurantDTO restaurantDTO) {

        Restaurant restaurant = modelMapper.map(restaurantDTO, Restaurant.class);

        return restaurantRepository.save(restaurant);
    }

    public Page<Restaurant> getAllRestaurants(int page, int size) {

        return restaurantRepository.findAll(PageRequest.of(page, size));
    }
    
    
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + id));
    }
    
}