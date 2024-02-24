package org.neatcode.services;

import lombok.NonNull;
import org.neatcode.models.restaurant.Restaurant;

import java.util.List;

public interface RestaurantService {

    void addRestaurant(@NonNull final Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(@NonNull final String restaurantId);

    List<Restaurant> getRestaurantsByName(@NonNull final String restaurantName);

    List<Restaurant> getRestaurantsByCity(@NonNull final String city);
}