package com.swish.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swish.invoice.entity.InvoiceEntity;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Integer>
{
	List<InvoiceEntity> findInvoiceByStatus(String status);
	
	List<InvoiceEntity> findInvoiceByInvValue(int invValue);
	
	List<InvoiceEntity> filterByStatusAndValue(String status, int invValue);
	
	List<InvoiceEntity> filterByStatus(String status);
}
