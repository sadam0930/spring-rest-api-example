package com.zola.example.rest.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice extends AuditModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "invoice_number")
	private String invoiceNumber;
	
	@Column(name = "po_number")
	private String poNumber;
	
	@Column(name = "due_date")
	private LocalDate dueDate;
	
	@Column(name = "amount_cents")
	private Long amountCents;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Long getAmountCents() {
		return amountCents;
	}

	public void setAmountCents(Long amountCents) {
		this.amountCents = amountCents;
	}
	
	@Override
	public String toString() {
		return String.format("Invoice[id=%d, poNumber='%s', dueDate='%s', amountCents='%s']", 
				id, poNumber, dueDate, amountCents);
	}
}