package com.instamart.invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instamart.invoice.entity.InvoiceEntity;
import com.instamart.invoice.exception.DeactivatedInvoiceException;
import com.instamart.invoice.repository.InvoiceRepository;
import com.instamart.invoice.request.InvoiceRequest;
import com.instamart.invoice.request.UpdateRequest;
import com.instamart.invoice.response.InvoiceResponse;

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
		entity.setNote(invoiceRequest.getNote());
		entity.setStatus(invoiceRequest.getStatus());
		entity.setDescription(invoiceRequest.getDescription());
		
		entity = invoiceRepository.save(entity);
		return entity.getInvId();
	}

	@Override
	public InvoiceResponse getInvoice(int invId) {
		InvoiceEntity entity = invoiceRepository.findById(invId).get();
		if(entity.getActiveStatus().equals("A")) {
			InvoiceResponse invoiceResponse = new InvoiceResponse();
			invoiceResponse.setInvId(entity.getInvId());
			invoiceResponse.setInvValue(entity.getInvValue());
			invoiceResponse.setGstNo(entity.getGstNo());
			invoiceResponse.setNote(entity.getNote());
			invoiceResponse.setStatus(entity.getStatus());
			invoiceResponse.setDescription(entity.getDescription());
			return invoiceResponse;
		}
		else
		{
			throw new DeactivatedInvoiceException("This invoice is deactive");
		}
	}

	@Override
	public int updateInvoiceById(UpdateRequest updateRequest) {
		InvoiceEntity entity = invoiceRepository.findById(updateRequest.getInvId()).get();
		
		if(updateRequest.getInvValue()!=null)
		{
			entity.setInvValue(updateRequest.getInvValue());
		}
		if(updateRequest.getGstNo()!=null)
		{
			entity.setGstNo(updateRequest.getGstNo());
		}
		if(updateRequest.getNote()!=null)
		{
			entity.setNote(updateRequest.getNote());
		}
		if(updateRequest.getStatus()!=null)
		{
			entity.setStatus(updateRequest.getStatus());
		}
		if(updateRequest.getDescription()!=null)
		{
			entity.setDescription(updateRequest.getDescription());
		}
		if(updateRequest.getActiveStatus()!=null)
		{
			entity.setActiveStatus(updateRequest.getActiveStatus());
		}
		
		entity = invoiceRepository.save(entity);
		
		return entity.getInvId();
	}

	@Override
	public String deleteInvoiceById(int invId) {
		InvoiceEntity entity = invoiceRepository.findById(invId).get();
		
		entity.setActiveStatus("D");
		entity = invoiceRepository.save(entity);
		if(entity!=null) {
			return "Invoice deleted successfully";
		}
		else {
			return "Unable to delete invoice";
		}
	}

}
