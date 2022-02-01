package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAllSales();
    Transaction findSalesById(Long id);
    Transaction saveOrUpdateSales(Transaction customer);
    void deleteSalesById(Long id);
}
