package com.deloitte.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.payment.model.dto.UtilityPayment;
import com.deloitte.payment.model.entity.UtilityPaymentEntity;

public interface UtilityPaymentRepository extends JpaRepository<UtilityPaymentEntity, UtilityPayment> {

}
