package com.nshuti.Event_management_ticket_booking_system_backend_application.exception;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(Long paymentId){
        super("Could not find payment with id" + paymentId);
    }
}
