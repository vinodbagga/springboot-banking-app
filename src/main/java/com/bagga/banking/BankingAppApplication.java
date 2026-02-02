package com.bagga.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bagga.banking.service.PaymentService;

@SpringBootApplication
public class BankingAppApplication implements CommandLineRunner {
	
	
	
	private final PaymentService  paymentService;
	
	public BankingAppApplication(PaymentService  paymentService){
		this.paymentService = paymentService;
	}
	
	public static void main(String[] args) {
		System.out.println("Application Started.........");
		SpringApplication.run(BankingAppApplication.class, args);
		System.out.println("Application Stopped.........");
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("run() Started.........");
		
		String payment = paymentService.payment();
		System.out.println("Payment  : "+payment);
		
		System.out.println("run() End.........");
	}

}
