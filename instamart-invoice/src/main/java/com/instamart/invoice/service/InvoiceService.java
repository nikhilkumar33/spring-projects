package com.instamart.invoice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.instamart.invoice.entity.InvoiceEntity;
import com.instamart.invoice.request.InvoiceRequest;

@Service
public interface InvoiceService 
{
	int saveInvoice(InvoiceRequest invoiceRequest);

	List<InvoiceEntity> getInvoiceByStatus(String status);
}
