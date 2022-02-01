package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.model.*;
import com.ym.projects.apis.posapi.repositories.TransactionDetailsRepository;
import com.ym.projects.apis.posapi.repositories.TransactionRepository;
import com.ym.projects.apis.posapi.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


class TransactionServiceImplTest extends BaseTestCase {
    private Transaction transaction;
    private TransactionDetails transactionDetails;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionDetailsRepository transactionDetailsRepository;

    private TransactionService transactionService;


    @BeforeEach
    void setUp() {
        transaction = Transaction.builder().id(ID).CreateBy(USER).UpdateBy(USER).CreateDate(CURRENT_DATE)
                .total_quantity(1).totalAmount(100).totalCostAmount(90).changeAmount(10).totalPayment(100)
                .build();
        transactionDetails= TransactionDetails.builder().transaction(transaction).id(ID).lineNo(1).quantity(1).uom(UnitOfMeasure.builder().id(ID).name(UOM).description(UOM).build()).transactionPrice(100).costOfGoodsSold(90).build();

        transactionService = new TransactionServiceImpl(transactionRepository, transactionDetailsRepository);
    }

    @Test
    void findAllSales() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        List<TransactionDetails> transactionDetailss = new ArrayList<>();
        transactionDetailss.add(transactionDetails);
        BDDMockito.given(transactionRepository.findAll()).willReturn(transactions);
        BDDMockito.given(transactionDetailsRepository.findByTransaction(transaction)).willReturn(transactionDetailss);

        transactionService.findAllSales();
        BDDMockito.then(transactionRepository).should().findAll();
    }

    @Test
    void findSalesById() {
        BDDMockito.given(transactionRepository.findById(ID)).willReturn(Optional.of(transaction));
        transactionService.findSalesById(ID);
        BDDMockito.then(transactionRepository).should().findById(ID);
    }

    @Test
    void saveOrUpdateSales() {
        BDDMockito.given(transactionRepository.save(any(Transaction.class))).willReturn(transaction);
        transactionService.saveOrUpdateSales(transaction);
        BDDMockito.then(transactionRepository).should(times(1)).save(transaction);
    }

    @Test
    void deleteCusomterById() {
        doNothing().when(transactionRepository).deleteById(anyLong());
      //  transactionService.deleteSaleseById(ID);
        verify(transactionRepository, times(1)).deleteById(ID);
    }
}