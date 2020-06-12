package com.joranbergfeld.paymentservice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        PaymentEntity saved = this.paymentRepository.save(PaymentEntity.fromPayment(payment));
        return PaymentEntity.toPayment(saved);
    }

    public Payment getPaymentById(long id) {
        return paymentRepository.findById(id).map(PaymentEntity::toPayment).orElse(null);
    }

    public List<Payment> getPayments() {
        return paymentRepository.findAll().stream().map(PaymentEntity::toPayment).collect(Collectors.toList());
    }

    public Payment confirmPayment(long id) {
        Optional<PaymentEntity> byId = paymentRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }

        Payment payment = PaymentEntity.toPayment(byId.get());
        payment.setStatus(PaymentStatus.COMPLETED);
        this.paymentRepository.save(PaymentEntity.fromPayment(payment));

        reportPaymentUpdate(payment);
        return payment;
    }

    private void reportPaymentUpdate(Payment payment) {
    }
}
