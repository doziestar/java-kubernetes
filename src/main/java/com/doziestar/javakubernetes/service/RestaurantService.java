package com.doziestar.javakubernetes.service;

import com.doziestar.javakubernetes.model.Restaurant;
import com.doziestar.javakubernetes.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant get(Long id) {
        return restaurantRepository.findById(id).get();
    }

    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    public void update(Long id, Restaurant restaurant) {
        Restaurant restaurantToUpdate = restaurantRepository.findById(id).get();
        restaurantToUpdate.setName(restaurant.getName());
        restaurantToUpdate.setAddress(restaurant.getAddress());
        restaurantToUpdate.setCapacity(restaurant.getCapacity());
        restaurantRepository.save(restaurantToUpdate);
    }
}
