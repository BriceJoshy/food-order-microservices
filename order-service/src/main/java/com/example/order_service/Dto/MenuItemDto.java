package com.example.order_service.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItemDto {
    private Long menuItemId;
    private String name;
    private String description;
    private Double price;
}
