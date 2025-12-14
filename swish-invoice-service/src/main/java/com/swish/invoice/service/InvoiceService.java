package com.swish.invoice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swish.invoice.entity.InvoiceEntity;
import com.swish.invoice.request.InvoiceRequest;

@Service
public interface InvoiceService 
{
	int saveInvoice(InvoiceRequest invoiceRequest);
	
	List<InvoiceEntity> getInvoiceByStatus(String status);
	
	List<InvoiceEntity> getInvoiceByFilter(String status, int invValue);

	List<InvoiceEntity> getInvoiceByValue(int invValue);
}
