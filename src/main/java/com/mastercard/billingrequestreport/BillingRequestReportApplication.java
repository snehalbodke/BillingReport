package com.mastercard.billingrequestreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mastercard"})

public class BillingRequestReportApplication {

	public static void main(String[] args) {

		SpringApplication.run(BillingRequestReportApplication.class, args);

		System.out.println("spring boot ");
	}

}
