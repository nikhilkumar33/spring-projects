package com.amazon.versoning.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazon.versoning.request.PaymentInfo;
import com.amazon.versoning.response.InvoiceResponse;
import com.amazon.versoning.service.InvoiceGeneratorService;

@Controller
public class InvoceControllerV1 
{
	@Autowired
	InvoiceGeneratorService invoiceGeneratorService;
	
	@PostMapping("generateInvoiceV1.0")
	@ResponseBody
	public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody PaymentInfo paymentInfo)
	{
		System.out.println(paymentInfo.getItemName());
		InvoiceResponse invoiceResponse = invoiceGeneratorService.generateInvoive(paymentInfo);
		
		return ResponseEntity.ok(invoiceResponse);
	}

}
