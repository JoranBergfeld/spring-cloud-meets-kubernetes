package com.joranbergfeld.paymentservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentContextConfiguration {


    @Bean
    public PaymentService paymentService(PaymentRepository paymentRepository) {
        return new PaymentService(paymentRepository);
    }
}
