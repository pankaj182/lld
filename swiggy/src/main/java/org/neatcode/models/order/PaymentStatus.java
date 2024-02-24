package org.neatcode.models.order;

public enum PaymentStatus {
    INITIATED,
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    FAILED,
    TIMEOUT, APPROVED, DECLINED, CANCELLED
}
