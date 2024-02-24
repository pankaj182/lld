package org.neatcode.services;

import lombok.NonNull;
import org.neatcode.models.restaurant.CuisineType;
import org.neatcode.models.restaurant.FoodMenu;
import org.neatcode.models.restaurant.MealType;
import org.neatcode.models.restaurant.MenuItem;

import java.util.List;

public interface FoodMenuService {

    public void addMenuByRestaurantId(@NonNull final String menuId,
                                      @NonNull final String restaurantId,
                                      @NonNull final List<MenuItem> menuItemList);

    public FoodMenu getMenuById(@NonNull final String menuId);

    public FoodMenu getMenuByRestaurantId(@NonNull final String restaurantId);

    public void addMenuItemsByMenuId(@NonNull final String menuId,
                                     @NonNull final List<MenuItem> menuItemList);

    public void addMenuItemsByRestaurantId(@NonNull final String restaurantId,
                                           @NonNull final List<MenuItem> menuItemList);

    public List<MenuItem> getMenuItemsByRestaurantIdAndCuisine(@NonNull final String restaurantId,
                                                               @NonNull final CuisineType cuisineType);
    public List<MenuItem> getMenuItemsByRestaurantIdAndMealType(@NonNull final String restaurantId,
                                                                @NonNull final MealType mealType);

    public MenuItem getMenuItemById(@NonNull final String itemId);
}