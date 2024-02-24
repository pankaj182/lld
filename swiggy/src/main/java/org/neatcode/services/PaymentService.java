package org.neatcode.services;

import lombok.NonNull;
import org.neatcode.models.order.Payment;

public interface PaymentService {
    public void addPayment(@NonNull final Payment payment);

    public Payment getPaymentById(@NonNull final String paymentId);

    public Payment getPaymentByOrderId(@NonNull final String orderId);
}