package com.nshuti.Event_management_ticket_booking_system_backend_application.controller;

import com.nshuti.Event_management_ticket_booking_system_backend_application.exception.PaymentNotFoundException;
import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Payment;
import com.nshuti.Event_management_ticket_booking_system_backend_application.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/register/payment")
    Payment newPayment(@RequestBody Payment newPayment){
        return paymentRepository.save(newPayment);
    }

    @GetMapping("/list/payments")
    List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    @GetMapping("/find/payment/{paymentId}")
    Payment getPaymentById(@PathVariable Long paymentId){
        return paymentRepository.findById(paymentId)
                .orElseThrow(()->new PaymentNotFoundException(paymentId));
    }

    @PutMapping("/edit/payment/{paymentId}")
    Payment updatePayment (@RequestBody Payment newPayment, @PathVariable Long paymentId){
        return paymentRepository.findById(paymentId)
                .map(payment -> {
                    payment.setPaymentId(newPayment.getPaymentId());
                    payment.setBooking(newPayment.getBooking());
                    payment.setAmount(newPayment.getAmount());
                    payment.setPaymentMethod(newPayment.getPaymentMethod());
                    payment.setPaymentDate(newPayment.getPaymentDate());
                    payment.setStatus(newPayment.getStatus());
                    return paymentRepository.save(payment);
                }).orElseThrow(()->new PaymentNotFoundException(paymentId));
    }

    @DeleteMapping("/payments/{paymentId}")
    String deletePayment(@PathVariable Long paymentId){
        if(!paymentRepository.existsById(paymentId)){
            throw new PaymentNotFoundException(paymentId);
        }
        paymentRepository.deleteById(paymentId);
        return "Payment with id "+paymentId+ "has been deleted successfully";
    }

}
