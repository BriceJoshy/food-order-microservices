package com.example.restaurant_service.Controller;


import com.example.restaurant_service.Dto.MenuDto;
import com.example.restaurant_service.Dto.MenuItemDto;
import com.example.restaurant_service.Dto.ResponseDto;
import com.example.restaurant_service.Entity.Menu;
import com.example.restaurant_service.Service.MenuService;
import com.example.restaurant_service.Service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/{restaurant_id}/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;

    }

    @PostMapping
    public ResponseEntity<ResponseDto> createMenu(@PathVariable("restaurant_id") Long restaurantId,
                                                  @Valid @RequestBody MenuDto menuDto){
        var res = menuService.createMenu(menuDto, restaurantId);
        var response = ResponseDto.getResponseDto("Menu created with for restaurant with id: " + restaurantId,
                HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/menuItem")
    public ResponseEntity<ResponseDto> addMenuItem(@PathVariable("restaurant_id") Long restaurantId,
                                                   @Valid @RequestBody MenuItemDto menuItemDto){
        var res = menuService.addMenuItem(menuItemDto, restaurantId);
        var response = ResponseDto.getResponseDto("Menu Item " + menuItemDto.getName() + " added to the menu", HttpStatus.CREATED);
        return  ResponseEntity.status(HttpStatus.CREATED).body((response));
    }

    @GetMapping
    public Menu getFullMenu(@PathVariable("restaurant_id") Long restaurantId){
        return menuService.getFullMenu(restaurantId);
    }
}
