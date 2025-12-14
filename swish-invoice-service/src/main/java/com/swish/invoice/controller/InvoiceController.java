package com.swish.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swish.invoice.entity.InvoiceEntity;
import com.swish.invoice.request.InvoiceRequest;
import com.swish.invoice.service.InvoiceService;

@RestController
public class InvoiceController 
{
	@Autowired
	InvoiceService invoiceService;
	
	
	@PostMapping("/generateInvoice")
	public ResponseEntity<String> generateInvoice(@RequestBody InvoiceRequest invoiceRequest)
	{
		System.out.println(invoiceRequest.getInvValue());
		
		int invId = invoiceService.saveInvoice(invoiceRequest);
		return ResponseEntity.ok("Invoice is generated successfully.."+invId);
	}
	
	@GetMapping("/getInvoiceByStatus/{status}")
	public ResponseEntity<List<InvoiceEntity>> getInvoiceByStatus(@PathVariable String status)
	{
		System.out.println(status);
		
		List<InvoiceEntity> invoices = invoiceService.getInvoiceByStatus(status);
		return ResponseEntity.ok(invoices);
	}
	
	@GetMapping("/getInvoiceByFilter/{status}/{invValue}")
	public ResponseEntity<List<InvoiceEntity>> getInvoiceByStatusAndValue(@PathVariable String status, @PathVariable int invValue)
	{
		System.out.println(status);
		System.out.println(invValue);
		List<InvoiceEntity> invoices = invoiceService.getInvoiceByFilter(status, invValue);
		return ResponseEntity.ok(invoices);
	}
	
	@GetMapping("/getInvoiceByValue/{invValue}")
	public ResponseEntity<List<InvoiceEntity>> getInvoiceByValue(@PathVariable int invValue)
	{
		System.out.println(invValue);
		
		List<InvoiceEntity> invoices = invoiceService.getInvoiceByValue(invValue);
		return ResponseEntity.ok(invoices);
	}
}
