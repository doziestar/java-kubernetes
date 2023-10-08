package com.doziestar.javakubernetes.repository;

import com.doziestar.javakubernetes.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
