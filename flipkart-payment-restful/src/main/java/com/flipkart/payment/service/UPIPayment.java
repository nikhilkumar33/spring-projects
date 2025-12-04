package com.flipkart.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.payment.dao.PaymentDAO;
import com.flipkart.payment.entity.Payment;
import com.flipkart.payment.request.PaymentInfo;

@Service
public class UPIPayment implements IPaymentService
{
	@Autowired
	PaymentDAO paymentDAO;
	
	@Override
	public int pay(PaymentInfo paymentInfo) 
	{
		System.out.println("UPIPayment....");
		Payment payment = new Payment();
		payment.setPaymentRef(paymentInfo.getPaymentRef());
		payment.setOrderId(paymentInfo.getOrderId());
		payment.setStatus(paymentInfo.getStatus());
		payment.setAmount(paymentInfo.getAmount());
		payment.setDescription(paymentInfo.getDescription());
		
		int paymentId = paymentDAO.confirmPayment(payment);
		return paymentId;
	}

}
