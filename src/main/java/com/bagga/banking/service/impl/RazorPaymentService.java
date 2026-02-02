package com.bagga.banking.service.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.bagga.banking.service.PaymentService;

@Component
@ConditionalOnProperty(havingValue = "razorpay", name = "payment.provider")
public class RazorPaymentService implements PaymentService {
	
	public String payment() {
		String payment = "Razorpay Payment";
		System.out.println("Payment From  : "+payment);
		return payment;
	}

}
