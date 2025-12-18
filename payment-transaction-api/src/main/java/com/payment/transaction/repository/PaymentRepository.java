package com.payment.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.transaction.entity.AccountEntity;

@Repository
public interface PaymentRepository extends JpaRepository<AccountEntity, Integer>
{
	AccountEntity findByAccountNo(String accountNo);
}
