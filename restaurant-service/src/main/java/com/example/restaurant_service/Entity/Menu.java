package com.example.restaurant_service.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference // Marks Menu as the child (prevents recursion)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference // Prevent recursion in Menu -> MenuItem relation
    private List<MenuItem> menuItemList;
}
