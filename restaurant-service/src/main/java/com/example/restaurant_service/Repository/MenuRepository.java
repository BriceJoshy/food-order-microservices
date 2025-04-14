package com.example.restaurant_service.Repository;

import com.example.restaurant_service.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
