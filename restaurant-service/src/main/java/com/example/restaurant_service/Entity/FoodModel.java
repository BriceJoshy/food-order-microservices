package com.example.restaurant_service.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "food_details")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodId;
    private String foodItem;
    private int price;
    private String foodDesc;

}
