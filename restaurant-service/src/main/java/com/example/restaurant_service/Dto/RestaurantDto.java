package com.example.restaurant_service.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {

    @NotEmpty(message = "The restaurant name should not be empty!!.")
    private String restaurantName;

    @NotEmpty(message = "The address should not be empty!!.")
    private String address;
}
