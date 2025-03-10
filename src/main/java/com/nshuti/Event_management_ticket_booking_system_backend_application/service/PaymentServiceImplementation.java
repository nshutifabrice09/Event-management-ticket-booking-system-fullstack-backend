package com.nshuti.Event_management_ticket_booking_system_backend_application.service;

import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImplementation implements PaymentService{

    @Override
    public List<Payment> getAllPayments() {
        return null;
    }

    @Override
    public Payment getPaymentById(Long bookingId) {
        return null;
    }

    @Override
    public Payment savePayment(Payment payment) {
        return null;
    }

    @Override
    public Payment updatePayment(Long bookingId, Payment payment) {
        return null;
    }

    @Override
    public void removeById(Long paymentId) {

    }
}
