package com.example.restaurant_service.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "menus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    private String menuName;

    @OneToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;
}
