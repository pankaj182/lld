package org.neatcode.services;

import lombok.NonNull;
import org.neatcode.models.restaurant.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CartService {
    void clearCart(@NonNull final String userId,
                          @NonNull final String restaurantId);

    void updateCart(@NonNull final String userId,
                           @NonNull final String restaurantId,
                           @NonNull final String itemId);

    List<MenuItem> getAllItemsOfCart(@NonNull final String userId,
                                            @NonNull final String restaurantId);
}
