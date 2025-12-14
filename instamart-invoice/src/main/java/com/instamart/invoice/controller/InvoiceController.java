package com.instamart.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instamart.invoice.entity.InvoiceEntity;
import com.instamart.invoice.request.InvoiceRequest;
import com.instamart.invoice.service.InvoiceService;

@RestController
public class InvoiceController 
{
	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping("/generateInvoice")
	public String generateInvoice(@RequestBody InvoiceRequest invoiceRequest)
	{
		int invId = invoiceService.saveInvoice(invoiceRequest);
		return "Inoice is generated successfully. Invoice id is: "+invId;
	}
	
	@GetMapping("/getInvoice/{status}")
	public String getInvoiceByStatus(@PathVariable String status)
	{
		List<InvoiceEntity> invoices = invoiceService.getInvoiceByStatus(status);
		return "Invoices get by status .. "+invoices.get(0).getDescription();
	}
}
