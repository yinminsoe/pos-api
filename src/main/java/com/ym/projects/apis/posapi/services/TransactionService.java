package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAllSales();
    Transaction findSalesById(Long id);
    Transaction saveOrUpdateSales(Transaction transaction);
    void deleteTransactionById(Long id);
}
