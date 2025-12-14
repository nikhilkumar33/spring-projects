package com.instamart.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instamart.invoice.entity.InvoiceEntity;
import com.instamart.invoice.repository.InvoiceRepository;
import com.instamart.invoice.request.InvoiceRequest;

@Service
public class InvoiceServiceImpl implements InvoiceService
{
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public int saveInvoice(InvoiceRequest invoiceRequest) {
		InvoiceEntity entity = new InvoiceEntity();
		entity.setInvValue(invoiceRequest.getInvValue());
		entity.setGstNo(invoiceRequest.getGstNo());
		entity.setStatus(invoiceRequest.getStatus());
		entity.setNote(invoiceRequest.getNote());
		entity.setDescription(invoiceRequest.getDescription());
		
		entity = invoiceRepository.save(entity);
		return entity.getInvId();
	}

	@Override
	public List<InvoiceEntity> getInvoiceByStatus(String status) {
		
		List<InvoiceEntity> invoices = invoiceRepository.findIndexByStatus(status);
		return invoices;
	}
	
	

}
