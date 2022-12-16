package com.deloitte.payment.model.mapper;

import org.springframework.beans.BeanUtils;

import com.deloitte.payment.model.dto.UtilityPayment;
import com.deloitte.payment.model.entity.UtilityPaymentEntity;

public class UtilityPaymentMapper extends BaseMapper<UtilityPaymentEntity, UtilityPayment> {
	
	 @Override
	    public UtilityPaymentEntity convertToEntity(UtilityPayment dto, Object... args) {
	        UtilityPaymentEntity entity = new UtilityPaymentEntity();
	        if (dto != null) {
	            BeanUtils.copyProperties(dto, entity);
	        }
	        return entity;
	    }

	    @Override
	    public UtilityPayment convertToDto(UtilityPaymentEntity entity, Object... args) {
	        UtilityPayment dto = new UtilityPayment();
	        if (entity != null) {
	            BeanUtils.copyProperties(entity, dto);
	        }
	        return dto;

}
}
