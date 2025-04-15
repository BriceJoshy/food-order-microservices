package com.example.restaurant_service.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemDto {

    @NotEmpty(message = "Menu item name cannot be empty")
    private String name;

    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Price cannot be null")
    private Double price;
}
