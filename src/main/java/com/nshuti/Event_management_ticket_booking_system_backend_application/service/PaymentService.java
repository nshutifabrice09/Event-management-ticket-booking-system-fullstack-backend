package com.nshuti.Event_management_ticket_booking_system_backend_application.service;
import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(Long bookingId);
    Payment savePayment(Payment payment);
    Payment updatePayment(Long bookingId, Payment payment);
    void removeById(Long paymentId);
}
