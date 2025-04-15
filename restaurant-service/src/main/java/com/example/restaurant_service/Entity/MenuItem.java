package com.example.restaurant_service.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.yaml.snakeyaml.DumperOptions;

@Entity
@Table(name = "menu_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuItemId;

    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    @JsonBackReference
    private Menu menu;

}
