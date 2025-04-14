package com.example.restaurant_service.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private long restaurantId;

    private String restaurantName;
    private String address;

    @OneToOne(mappedBy = "restaurant" , cascade = CascadeType.ALL)
    private Menu menu;



}
