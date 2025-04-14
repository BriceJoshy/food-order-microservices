package com.example.restaurant_service.Service;


import com.example.restaurant_service.Dto.RestaurantDto;
import com.example.restaurant_service.Entity.Restaurant;
import com.example.restaurant_service.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(RestaurantDto dto){
        Restaurant rest = Restaurant.builder()
                .restaurantName(dto.getRestaurantName())
                .address(dto.getAddress())
                .build();
        return restaurantRepository.save(rest);
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id){
        return restaurantRepository.findById(id);
    }
}
