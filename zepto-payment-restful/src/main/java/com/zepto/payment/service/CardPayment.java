package com.zepto.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.zepto.payment.bean.PaymentInfo;
import com.zepto.payment.entity.Payment;

@Primary
@Service
public class CardPayment implements PaymentService
{
	@Autowired
	PaymentDAO paymentDAO;
	
	@Override
	public int pay(PaymentInfo paymentInfo) {
		
		Payment payment = new Payment();
		payment.setPaymentRef(paymentInfo.getPaymentRef());
		payment.setOrderId(paymentInfo.getOrderId());
		payment.setAmount(paymentInfo.getAmount());
		payment.setStatus(paymentInfo.getStatus());
		payment.setDescription(paymentInfo.getDescription());
		
		int paymentId = paymentDAO.confirmPayment(payment);
		
		return paymentId;
	}

}
