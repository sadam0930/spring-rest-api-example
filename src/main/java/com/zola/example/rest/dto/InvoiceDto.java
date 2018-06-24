package com.zola.example.rest.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(
        value = {"id", "created_at"},
        allowGetters = true
)
public class InvoiceDto {
	@JsonProperty("id")
	@JsonIgnore
	private Long id;
	@JsonProperty("invoice_number")
	@NotNull
	private String invoiceNumber;
	@JsonProperty("po_number")
	@NotNull
	private String poNumber;
	@JsonProperty("due_date")
	@NotNull
	private LocalDate dueDate;
	@JsonProperty("amount_cents")
	@NotNull
	private Long amountCents;
	@JsonProperty("created_at")
	@JsonIgnore
	private LocalDateTime createdAt = LocalDateTime.now();
	
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
