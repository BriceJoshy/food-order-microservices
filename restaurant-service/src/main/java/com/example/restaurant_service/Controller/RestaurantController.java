package com.example.restaurant_service.Controller;


import com.example.restaurant_service.Dto.ResponseDto;
import com.example.restaurant_service.Service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createFoodItem(@Valid @RequestBody FoodModel foodModel){
        var orders = FoodModel.builder()
                .foodItem(foodModel.getFoodItem())
                .price(foodModel.getPrice())
                .foodDesc(foodModel.getFoodDesc()).build();

        var res = restaurantService.createFoodItem(orders);
        var response = getResponseDto("Food created with id: " + res.getFoodId(),
                HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private static ResponseDto getResponseDto(Object message, HttpStatus status) {
        var response = ResponseDto.builder()
                .message(message)
                .status(status)
                .build();
        return response;
    }
}
