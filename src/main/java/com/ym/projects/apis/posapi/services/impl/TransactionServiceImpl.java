package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.entity.Transaction;
import com.ym.projects.apis.posapi.entity.TransactionDetails;
import com.ym.projects.apis.posapi.repositories.TransactionDetailsRepository;
import com.ym.projects.apis.posapi.repositories.TransactionRepository;
import com.ym.projects.apis.posapi.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

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
            sale.setTransactionDetails(new HashSet<>(transactionDetails));
        });
        return transaction;
    }

    @Override
    public Transaction findSalesById(Long id) {
        Transaction transaction = null;
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if(transactionOptional.isPresent()){
            transaction=transactionOptional.get();
            List<TransactionDetails> transactionDetails =transactionDetailsRepository.findByTransaction(transaction);
            transaction.setTransactionDetails(new HashSet<>(transactionDetails));
        }
        return transaction;

    }

    @Override
    public Transaction saveOrUpdateSales(Transaction transaction) {
       Transaction transactionResult  = null;
        Set<TransactionDetails> transactionDetailsResult = new LinkedHashSet<>();
        if(transaction != null && transaction.getTransactionDetails() != null && transaction.getTransactionDetails().size() > 0){
            transactionResult= transactionRepository.save(transaction);
            for(TransactionDetails transactionDetails: transaction.getTransactionDetails()){
                transactionDetails.setTransaction(transactionResult);
                transactionDetails= transactionDetailsRepository.save(transactionDetails);
                transactionDetailsResult.add(transactionDetails);
            }

            if(transactionDetailsResult.size() > 0)
                transactionResult.setTransactionDetails(transactionDetailsResult);
        }
        return transactionResult;
    }

    @Override
    public void deleteTransactionById(Long id) {
        Transaction transaction=Transaction.builder().id(id).build();
       List<TransactionDetails> transactionDetails= transactionDetailsRepository.findByTransaction(transaction);

        if(transactionDetails != null &&  transactionDetails.size() > 0){
           if(transactionDetails.get(0).getTransaction().getId().equals(id)){
               transactionDetailsRepository.deleteByTransaction(transaction);
               transactionRepository.deleteById(id);
           }
        }
    }
}
