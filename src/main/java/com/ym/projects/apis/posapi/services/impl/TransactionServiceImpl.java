package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.model.Transaction;
import com.ym.projects.apis.posapi.model.TransactionDetails;
import com.ym.projects.apis.posapi.repositories.TransactionDetailsRepository;
import com.ym.projects.apis.posapi.repositories.TransactionRepository;
import com.ym.projects.apis.posapi.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionDetailsRepository transactionDetailsRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionDetailsRepository transactionDetailsRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionDetailsRepository = transactionDetailsRepository;
    }

    @Override
    public List<Transaction> findAllSales() {
        List<Transaction> transaction= transactionRepository.findAll();
        transaction.forEach(sale->{
            //find Details
            List<TransactionDetails> transactionDetails = transactionDetailsRepository.findByTransaction(sale);
            if(transactionDetails != null)
            sale.setSaleDetails(transactionDetails.stream().collect(Collectors.toSet()));
        });
        return transaction;
    }

    @Override
    public Transaction findSalesById(Long id) {
        return null;
    }

    @Override
    public Transaction saveOrUpdateSales(Transaction customer) {
        return null;
    }

    @Override
    public void deleteSalesById(Long id) {

    }
}
