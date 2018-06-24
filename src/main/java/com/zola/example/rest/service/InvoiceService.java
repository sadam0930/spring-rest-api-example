package com.zola.example.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zola.example.rest.converter.InvoiceConverter;
import com.zola.example.rest.dto.InvoiceDto;
import com.zola.example.rest.entity.Invoice;
import com.zola.example.rest.repository.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
    private InvoiceRepository invoiceRepository;
	
	public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        Invoice invoice = InvoiceConverter.convertDtoToEntity(invoiceDto);
    	invoice = invoiceRepository.save(invoice);
    	InvoiceDto response = InvoiceConverter.convertEntityToDto(invoice);
    	return response;
	}
	
	public Page<Invoice> getInvoices(String invoiceNumber, String poNumber, Pageable pageable) {
		if(null != invoiceNumber) {
			return invoiceRepository.findByInvoiceNumberOrderByCreatedAtDesc(invoiceNumber, pageable);
		} else {
			return invoiceRepository.findByPoNumberOrderByCreatedAtDesc(poNumber, pageable);
		} 
	}
	
}
