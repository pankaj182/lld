package org.neatcode.services;

import lombok.NonNull;
import org.neatcode.models.order.Delivery;
import org.neatcode.models.order.OrderStatus;

import java.util.List;

public interface DeliveryService {

    void addDelivery(@NonNull final Delivery delivery);

    Delivery getDeliveryById(@NonNull final String deliveryId);

    List<Delivery> getDeliveriesByDeliveryBoyId(@NonNull final String deliveryBoyId);

    OrderStatus getOrderStatus(@NonNull final String deliveryId);
}