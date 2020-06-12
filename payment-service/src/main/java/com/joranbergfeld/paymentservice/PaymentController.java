package com.joranbergfeld.paymentservice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public ResponseEntity<List<PaymentResponse>> getAll() {
        return new ResponseEntity<>(
            this.paymentService.getPayments().stream().map(PaymentResponse::fromPayment).collect(Collectors.toList()),
            HttpStatus.OK);
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<PaymentResponse> getById(@PathVariable("id") long id) {
        Optional<Payment> optionalPayment = Optional.ofNullable(this.paymentService.getPaymentById(id));
        return optionalPayment.map(payment -> new ResponseEntity<>(PaymentResponse.fromPayment(payment), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody CreatePaymentRequest request) {
        Optional<Payment> optionalPayment = Optional.ofNullable(this.paymentService.createPayment(CreatePaymentRequest.toPayment(request)));
        return optionalPayment.map(payment -> new ResponseEntity<>(PaymentResponse.fromPayment(payment), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/payment/{id}/confirm")
    public ResponseEntity<PaymentResponse> confirmPayment(@PathVariable("id") long id) {
        Optional<Payment> optionalPayment = Optional.ofNullable(this.paymentService.confirmPayment(id));
        return optionalPayment.map(payment -> new ResponseEntity<>(PaymentResponse.fromPayment(payment), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
