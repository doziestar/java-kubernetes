package com.doziestar.javakubernetes.controller;

import com.doziestar.javakubernetes.model.Restaurant;
import com.doziestar.javakubernetes.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {


    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/")
    public ResponseEntity<Restaurant> createRestaurant(Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.save(restaurant));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        restaurantService.delete(id);
        return ResponseEntity.ok("Resturant deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRestaurant(@PathVariable Long id, Restaurant restaurant) {
        restaurantService.update(id, restaurant);
        return ResponseEntity.ok("Restaurant updated successfully");
    }
}
