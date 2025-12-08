package com.amazon.versoning.controller.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.versoning.request.PaymentInfo;
import com.amazon.versoning.response.InvoiceResponse;
import com.amazon.versoning.service.InvoiceGeneratorService;

@RestController
public class InvoiceControllerV2 
{
	@Autowired
	InvoiceGeneratorService invoiceGeneratorService;
	
	@PostMapping("generateInvoiceV2.0")
	@ResponseBody
	public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody PaymentInfo paymentInfo)
	{
		System.out.println(paymentInfo.getItemName());
		InvoiceResponse invoiceResponse = invoiceGeneratorService.generateInvoiveWithGST(paymentInfo);
		
		return ResponseEntity.ok(invoiceResponse);
	}

}
