package com.example.restaurant_service.Repository;

import com.example.restaurant_service.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
