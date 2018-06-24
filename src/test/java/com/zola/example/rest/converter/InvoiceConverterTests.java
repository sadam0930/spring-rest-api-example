package com.zola.example.rest.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.zola.example.rest.dto.InvoiceDto;
import com.zola.example.rest.entity.Invoice;

@RunWith(SpringRunner.class)
public class InvoiceConverterTests {
	@Test
	public void convertInvoiceDtoToEntity() {
		InvoiceDto invoiceDto = new InvoiceDto();
		invoiceDto.setAmountCents(10000L);
		invoiceDto.setPoNumber("testnumber");
		invoiceDto.setInvoiceNumber("1QWERTY");
		invoiceDto.setDueDate(LocalDate.now());
		invoiceDto.setId(4L);
		invoiceDto.setCreatedAt(LocalDateTime.now());
		
		Invoice invoice = InvoiceConverter.convertDtoToEntity(invoiceDto);
		
		assertEquals(invoice.getAmountCents(), invoiceDto.getAmountCents());
		assertEquals(invoice.getPoNumber(), invoiceDto.getPoNumber());
		assertEquals(invoice.getInvoiceNumber(), invoiceDto.getInvoiceNumber());
		assertEquals(invoice.getDueDate(), invoiceDto.getDueDate());
		assertEquals(invoice.getId(), invoiceDto.getId());
		assertEquals(invoice.getCreatedAt(), invoiceDto.getCreatedAt());
	}
	
	@Test
	public void convertInvoiceToDto() {
		Invoice invoice = new Invoice();
		invoice.setAmountCents(10000L);
		invoice.setPoNumber("testnumber");
		invoice.setInvoiceNumber("1QWERTY");
		invoice.setDueDate(LocalDate.now());
		invoice.setId(4L);
		invoice.setCreatedAt(LocalDateTime.now());
		
		InvoiceDto invoiceDto = InvoiceConverter.convertEntityToDto(invoice);
		
		assertEquals(invoice.getAmountCents(), invoiceDto.getAmountCents());
		assertEquals(invoice.getPoNumber(), invoiceDto.getPoNumber());
		assertEquals(invoice.getInvoiceNumber(), invoiceDto.getInvoiceNumber());
		assertEquals(invoice.getDueDate(), invoiceDto.getDueDate());
		assertEquals(invoice.getId(), invoiceDto.getId());
		assertEquals(invoice.getCreatedAt(), invoiceDto.getCreatedAt());
	}
}
