package com.ym.projects.apis.posapi.repositories;

import com.ym.projects.apis.posapi.model.Transaction;
import com.ym.projects.apis.posapi.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {
    List<TransactionDetails> findByTransaction(Transaction transaction);
}
