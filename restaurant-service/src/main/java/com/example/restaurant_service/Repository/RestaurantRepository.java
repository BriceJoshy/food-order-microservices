package com.example.restaurant_service.Repository;

import com.example.restaurant_service.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
