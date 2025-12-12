package com.zepto.invoice.controller;
import com.zepto.invoice.service.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.invoice.request.InvoiceRequest;
import com.zepto.invoice.response.InvoiceResponse;
import com.zepto.invoice.service.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;

	
	@PostMapping("/generateInvoice")
	public String generateInvoice(@RequestBody InvoiceRequest invoiceRequest)
	{
		int invId = invoiceService.createInvoice(invoiceRequest);
		return "Your invoice is generated successfully.. Invoice id is: "+invId;
	}
	
	@PostMapping("/getInvoiceById")
	public ResponseEntity<InvoiceResponse> getInvoice(@RequestBody int invoiceId)
	{
		InvoiceResponse invResponse = invoiceService.getInvoice(invoiceId);
		return ResponseEntity.ok(invResponse);
	}
	
	@PutMapping("/updateInvoice")
	public ResponseEntity<String> updateInvoice(@RequestBody InvoiceRequest invoiceRequest)
	{
		System.out.println(invoiceRequest.getInvValue());
		int invId = invoiceService.updateInvoice(invoiceRequest);
		return ResponseEntity.ok("Invoice update successfully.. Invoice id is: "+invId);
	}
	
	@PostMapping("/deleteInvoiceById")
	public ResponseEntity<String> deleteInvoice(@RequestBody int invoiceId)
	{
		String msg = invoiceService.deleteInvoice(invoiceId);
		return ResponseEntity.ok(msg);
	}

}
