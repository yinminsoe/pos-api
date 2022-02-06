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

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


class TransactionServiceImplTest extends BaseTestCase {
    private Employee employee;
    private Transaction transaction;
    private TransactionDetails transactionDetails;
    private  Set<TransactionDetails> transactionDetailss = new HashSet<>();

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionDetailsRepository transactionDetailsRepository;

    private TransactionService transactionService;


    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .id(ID).person(Person.builder().firstName("First Name").lastName("Last Name").middleName("middle Name").build())
                .address(Address.builder().address1("Address 1").address2("Address 2").build())
                .phone(Phone.builder().phone1("Phone 1").phone2("Phone 2").phone3("Phone 3").build())
                .role(Role.ADMIN)
                .build();
        transaction = Transaction.builder().id(ID).CreateBy(USER).UpdateBy(USER).CreateDate(CURRENT_DATE)
                .employee(employee).total_quantity(1).totalAmount(100).totalCostAmount(90).changeAmount(10).totalPayment(100)
                .build();
        transactionDetails= TransactionDetails.builder().transaction(transaction).id(ID).lineNo(1).quantity(1).uom(UnitOfMeasure.builder().id(ID).name(UOM).description(UOM).build()).transactionPrice(100).costOfGoodsSold(90).build();

        transactionDetailss.add(transactionDetails);
        transaction.setTransactionDetails(transactionDetailss);
        transactionService = new TransactionServiceImpl(transactionRepository, transactionDetailsRepository);
    }

    @Test
    void findAllSales() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        BDDMockito.given(transactionRepository.findAll()).willReturn(transactions);
        BDDMockito.given(transactionDetailsRepository.findByTransaction(transaction)).willReturn(new ArrayList<>(transactionDetailss));

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
        BDDMockito.given(transactionDetailsRepository.save(any(TransactionDetails.class))).willReturn(transactionDetails);
        transactionService.saveOrUpdateSales(transaction);
        BDDMockito.then(transactionRepository).should(times(1)).save(transaction);
    }

    @Test
    void deleteSalesById() {
        doNothing().when(transactionRepository).deleteById(ID);
        doNothing().when(transactionDetailsRepository).deleteByTransaction(transaction);

        when(transactionDetailsRepository.findByTransaction(transaction)).thenReturn(new ArrayList<>(transactionDetailss));
        transactionService.deleteTransactionById(ID);
        verify(transactionRepository, times(1)).deleteById(ID);
    }
}