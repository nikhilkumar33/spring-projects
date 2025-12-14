package com.instamart.invoice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instamart.invoice.entity.InvoiceEntity;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Integer>
{
	List<InvoiceEntity> findIndexByStatus(String status);
}
