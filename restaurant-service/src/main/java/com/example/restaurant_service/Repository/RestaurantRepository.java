package com.example.restaurant_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<FoodModel, Long> {
}
