package com.instamart.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instamart.invoice.request.InvoiceRequest;
import com.instamart.invoice.request.UpdateRequest;
import com.instamart.invoice.response.InvoiceResponse;
import com.instamart.invoice.service.InvoiceService;

@RestController
public class InvoiceController
{
	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping("generateInvoice")
	public String generateInvoice(@RequestBody InvoiceRequest invoiceRequest)
	{
		int invId = invoiceService.createInvoice(invoiceRequest);
		return "Your invoice is generated successfully. Invoice id is: "+invId;
	}
	
	@GetMapping("getInvoiceById")
	public ResponseEntity<InvoiceResponse> getInvoiceById(@RequestBody int invId)
	{
		InvoiceResponse invoiceResponse = invoiceService.getInvoice(invId);
		return ResponseEntity.ok(invoiceResponse);
	}
	
	@PatchMapping("updateInvoice")
	public ResponseEntity<String> updateInvoice(@RequestBody UpdateRequest updateRequest)
	{
		int invId= invoiceService.updateInvoiceById(updateRequest);
		return ResponseEntity.ok(invId+" invoice id is updated");
	}
	
	@DeleteMapping("deleteInvoice")
	public ResponseEntity<String> deleteInvoice(@RequestBody int invId)
	{
		String message = invoiceService.deleteInvoiceById(invId);
		return ResponseEntity.ok(message);
	}
}