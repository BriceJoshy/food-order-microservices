package com.example.order_service.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerName;
    private List<String> foodList;
}
