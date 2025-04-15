package com.example.restaurant_service.Dto;

import com.example.restaurant_service.Entity.MenuItem;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto {

    @NotEmpty(message = "Menu name cannot be empty!!.")
    private String menuName;

    @NotEmpty(message = "Menu cannot be empty")
    private List<MenuItemDto> menuItemList;

}
