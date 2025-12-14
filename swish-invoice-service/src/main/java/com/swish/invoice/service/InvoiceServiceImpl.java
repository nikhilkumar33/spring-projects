package com.swish.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swish.invoice.entity.InvoiceEntity;
import com.swish.invoice.exception.NoDataFoundException;
import com.swish.invoice.repository.InvoiceRepository;
import com.swish.invoice.request.InvoiceRequest;

import jakarta.persistence.EntityManager;

@Service
public class InvoiceServiceImpl implements InvoiceService
{
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	EntityManager entityManager;

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
		
		//List<InvoiceEntity> invoices = invoiceRepository.findInvoiceByStatus(status);
		
		List<InvoiceEntity> invoices = entityManager.createNamedQuery("InvoiceEntity.filterByStatus",InvoiceEntity.class)
							.setParameter("status", status).getResultList();
		
		if(invoices.isEmpty())
		{
			throw new NoDataFoundException("No data found");
		}
		return invoices;
	}

	@Override
	public List<InvoiceEntity> getInvoiceByFilter(String status, int invValue) {
		
		List<InvoiceEntity> invoices = entityManager.createNamedQuery("filterByStatusAndValue",InvoiceEntity.class)
														.setParameter("status", status).setParameter("invValue", invValue).getResultList();
		
		if(invoices.isEmpty())
		{
			throw new NoDataFoundException("No data found");
		}
		return invoices;
	}

	@Override
	public List<InvoiceEntity> getInvoiceByValue(int invValue) {
		
		List<InvoiceEntity> invoices = invoiceRepository.findInvoiceByInvValue(invValue);
		
		if(invoices.isEmpty()) {
			throw new NoDataFoundException("No data found with this value");
		}
		return invoices;
	}

}
