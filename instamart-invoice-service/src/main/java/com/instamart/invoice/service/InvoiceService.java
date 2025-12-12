package com.instamart.invoice.service;

import org.springframework.stereotype.Service;

import com.instamart.invoice.request.InvoiceRequest;
import com.instamart.invoice.request.UpdateRequest;
import com.instamart.invoice.response.InvoiceResponse;

@Service
public interface InvoiceService 
{
	
	int createInvoice(InvoiceRequest invoiceRequest);

	InvoiceResponse getInvoice(int invId);

	int updateInvoiceById(UpdateRequest updateRequest);

	String deleteInvoiceById(int invId);

}
