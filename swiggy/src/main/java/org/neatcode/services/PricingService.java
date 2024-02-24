package org.neatcode.services;

import lombok.NonNull;
import org.neatcode.models.order.Bill;
import org.neatcode.models.order.CouponCode;

public interface PricingService {
    public Bill getBill(@NonNull final String userId,
                        @NonNull final String restaurantId,
                        @NonNull final CouponCode couponCode);
}
