package com.bagga.banking.service.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.bagga.banking.service.PaymentService;

@Component
@ConditionalOnProperty(havingValue = "gpay",name = "payment.provider")
public class GooglePay implements PaymentService {

	@Override
	public String payment() {
		String payment = "GooglePay Payment";
		System.out.println("Payment From  : "+payment);
		return payment;
	}

}
