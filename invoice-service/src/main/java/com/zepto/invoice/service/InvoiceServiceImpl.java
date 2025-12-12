package com.zepto.invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.invoice.entity.InvoiceEntity;
import com.zepto.invoice.repository.InvoiceRepository;
import com.zepto.invoice.request.InvoiceRequest;
import com.zepto.invoice.response.InvoiceResponse;

@Service
public class InvoiceServiceImpl implements InvoiceService
{
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public int createInvoice(InvoiceRequest invoiceRequest) {
		InvoiceEntity entity = new InvoiceEntity();
		entity.setInvValue(invoiceRequest.getInvValue());
		entity.setGstNo(invoiceRequest.getGstNo());
		entity.setDescription(invoiceRequest.getDescription());
		entity.setNote(invoiceRequest.getNote());
		entity.setStatus(invoiceRequest.getStatus());
		
		entity = invoiceRepository.save(entity);
		return entity.getInvId();
	}

	
	@Override
	public int updateInvoice(InvoiceRequest invoiceRequest) {
		
		
		InvoiceEntity entity = invoiceRepository.findById(invoiceRequest.getInvId()).get();
	
		if(invoiceRequest.getInvValue()!=0) {
			entity.setInvValue(invoiceRequest.getInvValue());
		}
		if(invoiceRequest.getDescription() != null &&!invoiceRequest.getDescription().isEmpty()) {
			entity.setDescription(invoiceRequest.getDescription());
		}
		if(invoiceRequest.getNote() != null && !invoiceRequest.getNote().isEmpty()) {
			entity.setNote(invoiceRequest.getNote());
		}
		if(invoiceRequest.getGstNo() != null && !invoiceRequest.getGstNo().isEmpty()) {
			entity.setGstNo(invoiceRequest.getGstNo());
		}
		if(invoiceRequest.getStatus() != null && !invoiceRequest.getStatus().isEmpty()) {
			entity.setStatus(invoiceRequest.getStatus());
		}
		
		entity = invoiceRepository.save(entity);
		return entity.getInvId();
	}
	
	@Override
	public InvoiceResponse getInvoice(int invoiceId) {
		
		InvoiceEntity invoice= invoiceRepository.findById(invoiceId).get();
		
		InvoiceResponse invoiceResponse = new InvoiceResponse();
		invoiceResponse.setInvId(invoice.getInvId());
		invoiceResponse.setInvValue(invoice.getInvValue());
		invoiceResponse.setDescription(invoice.getDescription());
		invoiceResponse.setGstNo(invoice.getGstNo());
		invoiceResponse.setStatus(invoice.getStatus());
		invoiceResponse.setNote(invoice.getNote());

		return invoiceResponse;
	}


	@Override
	public String deleteInvoice(int invoiceId) {
		invoiceRepository.deleteById(invoiceId);
		return "Deleted successfully";
	}

}
