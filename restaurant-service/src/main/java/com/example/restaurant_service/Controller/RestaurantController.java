package com.example.restaurant_service.Controller;


import com.example.restaurant_service.Dto.ResponseDto;
import com.example.restaurant_service.Dto.RestaurantDto;
import com.example.restaurant_service.Entity.Restaurant;
import com.example.restaurant_service.Service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createRestaurant(@Valid @RequestBody RestaurantDto restaurantDto){


        var res = restaurantService.createRestaurant(restaurantDto);
        var response = ResponseDto.getResponseDto("Restaurant created with id: " + res.getRestaurantId(),
                HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }


    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable Long id){
        return restaurantService.getRestaurantById(id);
    }


//    private static ResponseDto getResponseDto(Object message, HttpStatus status) {
//        return ResponseDto.builder()
//                .message(message)
//                .status(status)
//                .build();
//    }
}
