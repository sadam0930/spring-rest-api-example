package com.zola.example.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zola.example.rest.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	Page<Invoice> findByInvoiceNumberOrderByCreatedAtDesc(String invoiceNumber, Pageable pageable);
	Page<Invoice> findByPoNumberOrderByCreatedAtDesc(String poNumber, Pageable pageable);
}
