package com.amazon.versoning.service;

import org.springframework.stereotype.Service;

import com.amazon.versoning.request.PaymentInfo;
import com.amazon.versoning.response.InvoiceResponse;

@Service
public interface InvoiceGeneratorService 
{
	double CENTVATPERCENT=0.5;
	double STATEVATPERCENT=0.12;

	double GSTPERCENT=0.18;
	
	InvoiceResponse generateInvoive(PaymentInfo paymentInfo);

	InvoiceResponse generateInvoiveWithGST(PaymentInfo paymentInfo);
}
