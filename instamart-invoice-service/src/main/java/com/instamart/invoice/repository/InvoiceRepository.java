package com.instamart.invoice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instamart.invoice.entity.InvoiceEntity;

@Repository
public interface InvoiceRepository  extends CrudRepository<InvoiceEntity, Integer>
{

}
