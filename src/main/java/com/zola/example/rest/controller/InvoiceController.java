package com.zola.example.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.zola.example.rest.dto.InvoiceDto;
import com.zola.example.rest.entity.Invoice;
import com.zola.example.rest.service.InvoiceService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/v1/invoices")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;

	/*
	 * If both invoice number and PO number are given, endpoint will return search by invoice number
	 */
	@GetMapping
    public Page<Invoice> getInvoicesByInvoiceNumber(@RequestParam(value = "invoice_number", required=false) String invoiceNumber, 
    												@RequestParam(value = "po_number", required=false) String poNumber, Pageable pageable) {
        return invoiceService.getInvoices(invoiceNumber, poNumber, pageable);
    }

    @PostMapping
    public InvoiceDto createInvoice(@Valid @RequestBody InvoiceDto invoiceDto) {
    	return invoiceService.createInvoice(invoiceDto);
    }
}