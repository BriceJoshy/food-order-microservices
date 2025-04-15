package com.example.restaurant_service.Service;

import com.example.restaurant_service.Dto.MenuDto;
import com.example.restaurant_service.Dto.MenuItemDto;
import com.example.restaurant_service.Entity.Menu;
import com.example.restaurant_service.Entity.MenuItem;
import com.example.restaurant_service.Entity.Restaurant;
import com.example.restaurant_service.Repository.MenuItemRepository;
import com.example.restaurant_service.Repository.MenuRepository;
import com.example.restaurant_service.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public Menu createMenu(MenuDto dto, Long restaurantId){
        Restaurant restaurant = restaurantRepository
                .findById(restaurantId).orElseThrow(() ->
                        new RuntimeException("Restaurant not found!"));


        Menu menu = Menu.builder()
                .menuName(dto.getMenuName())
                .restaurant(restaurant)
                .build();

        List<MenuItem> menuItems = dto.getMenuItemList().stream()
                .map(itemDto -> MenuItem.builder()
                        .name(itemDto.getName())
                        .description(itemDto.getDescription())
                        .price(itemDto.getPrice())
                        .menu(menu)  // set the menu
                        .build()
                )
                .toList();
        menu.setMenuItemList(menuItems);
        return menuRepository.save(menu);
    }

    public MenuItem addMenuItem(MenuItemDto menuItemDto, Long restaurantId){
        Restaurant restaurant = restaurantRepository
                .findById(restaurantId).orElseThrow(() ->
                        new RuntimeException("Restaurant not found!"));

        Menu menu = restaurant.getMenu();

//        creating default menu if not exists
        if (menu == null) {
            menu = Menu.builder()
                    .menuName("Default Menu")
                    .restaurant(restaurant)
                    .build();
            menuRepository.save(menu);
            restaurant.setMenu(menu);
        }
        MenuItem menuItem = MenuItem.builder()
                .menu(menu)
                .name(menuItemDto.getName())
                .description(menuItemDto.getDescription())
                .price(menuItemDto.getPrice())
                .build();

        MenuItem savedItem = menuItemRepository.save(menuItem);

        menu.getMenuItemList().add(savedItem);

        menuRepository.save(menu);

        return savedItem;
    }

    public Menu getFullMenu(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        return restaurant.getMenu();
    }

}
