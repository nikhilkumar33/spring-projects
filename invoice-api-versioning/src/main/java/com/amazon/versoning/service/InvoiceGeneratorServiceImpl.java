package com.amazon.versoning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.versoning.dao.InvoiceSaverDAO;
import com.amazon.versoning.entity.Invoice;
import com.amazon.versoning.exception.PaymentFailedException;
import com.amazon.versoning.request.PaymentInfo;
import com.amazon.versoning.response.InvoiceResponse;

@Service
public class InvoiceGeneratorServiceImpl implements InvoiceGeneratorService
{
	
	@Autowired
	InvoiceSaverDAO invoiceSaverDAO;
	
	@Override
	public InvoiceResponse generateInvoive(PaymentInfo paymentInfo) 
	{
		Invoice invoice = new Invoice();
		invoice.setPaymentId(paymentInfo.getPaymentId());
		invoice.setItemName(paymentInfo.getItemName());
		if(paymentInfo.getStatus().equals("PAID"))
		{
			invoice.setDescription("Your item is delivered to your given address:"+paymentInfo.getAddress());
		}
		else {
			throw new PaymentFailedException("Payment failed..!");
		}
		invoice.setTotalAmount(calculateTotalAmountWithVAT(paymentInfo.getAmount()));
		
		int invoiceId = invoiceSaverDAO.createInvoice(invoice);
		invoice.setInvoiceId(invoiceId);
		
		InvoiceResponse invoiceResponse = generateInvoiceResponse(invoice);
		invoiceResponse.setTotalAmount("Total amount + VAT : "+invoice.getTotalAmount());
		return invoiceResponse;
	}
	
	public String calculateTotalAmountWithVAT(String amount)
	{
		double vatAmount = (Integer.parseInt(amount)*CENTVATPERCENT)*STATEVATPERCENT;
		
		double totalAmount= Integer.parseInt(amount)+vatAmount;
		return Double.toString(totalAmount);
	}
	
	public String calculateTotalAmountWithGST(String amount)
	{
		double gstAmount = Integer.parseInt(amount)*GSTPERCENT;
		
		double totalAmount= Integer.parseInt(amount)+gstAmount;
		return Double.toString(totalAmount);
	}

	
	public InvoiceResponse generateInvoiceResponse(Invoice invoice)
	{
		InvoiceResponse invoiceResponse = new InvoiceResponse();
		invoiceResponse.setInvoiceId("Invoice id : "+invoice.getInvoiceId());
		invoiceResponse.setPaymentId("Transaction id : "+invoice.getPaymentId());
		invoiceResponse.setItemName("Product name: "+invoice.getItemName());
		invoiceResponse.setDescription("Delivery status : "+invoice.getDescription());
		return invoiceResponse;
	}

	@Override
	public InvoiceResponse generateInvoiveWithGST(PaymentInfo paymentInfo) {
		Invoice invoice = new Invoice();
		invoice.setPaymentId(paymentInfo.getPaymentId());
		invoice.setItemName(paymentInfo.getItemName());
		if(paymentInfo.getStatus().equals("PAID"))
		{
			invoice.setDescription("Your item is delivered to your given address:"+paymentInfo.getAddress());
		}
		else {
			throw new PaymentFailedException("Payment failed..!");
		}
		invoice.setTotalAmount(calculateTotalAmountWithGST(paymentInfo.getAmount()));
		
		int invoiceId = invoiceSaverDAO.createInvoice(invoice);
		invoice.setInvoiceId(invoiceId);
		
		InvoiceResponse invoiceResponse = generateInvoiceResponse(invoice);
		invoiceResponse.setTotalAmount("Total amount + GST : "+invoice.getTotalAmount());

		return invoiceResponse;
	}

}
