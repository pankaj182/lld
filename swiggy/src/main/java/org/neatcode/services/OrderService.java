package org.neatcode.services;

import lombok.NonNull;
import org.neatcode.models.order.Order;
import org.neatcode.models.order.OrderCommandType;

import java.util.List;

public interface OrderService {
    public void updateOrder(@NonNull final Order order,
                            @NonNull final OrderCommandType orderCommandType);

    public Order getOrderById(@NonNull final String orderId);

    public List<Order> getAllOrdersByRestaurantId(@NonNull final String userId,
                                                  @NonNull final String restaurantId);
    public List<Order> getAllOrders(@NonNull final String userId);

}
