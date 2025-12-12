package com.zepto.invoice.service;

import org.springframework.stereotype.Service;

import com.zepto.invoice.request.InvoiceRequest;
import com.zepto.invoice.response.InvoiceResponse;

@Service
public interface InvoiceService 
{
	int createInvoice(InvoiceRequest invoiceRequest);

	InvoiceResponse getInvoice(int invoiceId);

	int updateInvoice(InvoiceRequest invoiceRequest);

	String deleteInvoice(int invoiceId);
}
