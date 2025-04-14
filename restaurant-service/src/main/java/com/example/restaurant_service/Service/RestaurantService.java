package com.example.restaurant_service.Service;


import com.example.restaurant_service.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RestaurantService {

    @Autowired
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public FoodModel createFoodItem(FoodModel food){
        return restaurantRepository.save(food);
    }

    public Optional<FoodModel> getFoodItemById(Long id){
        return restaurantRepository.findById(id);
    }
    public List<FoodModel> displayMenu(){
        return restaurantRepository.findAll();
    }
}
