package com.deloitte.payment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.deloitte.payment.rest.request.UtilityPaymentRequest;
import com.deloitte.payment.service.UtilityPaymentService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/utility-payment")
public class UtilityPaymentController {
	
	 private  UtilityPaymentService utilityPaymentService;

	    @GetMapping
	    public ResponseEntity readPayments(Pageable pageable) {
	        return ResponseEntity.ok(utilityPaymentService.readPayments(pageable));
	    }

	    @PostMapping
	    public ResponseEntity processPayment(@RequestBody UtilityPaymentRequest paymentRequest) {
	        return ResponseEntity.ok(utilityPaymentService.utilPayment(paymentRequest));
	    }


}
