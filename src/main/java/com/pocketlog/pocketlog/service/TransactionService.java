package com.pocketlog.pocketlog.service;

import com.pocketlog.pocketlog.domain.Transaction;
import com.pocketlog.pocketlog.dto.incoming.TransactionCreation;
import com.pocketlog.pocketlog.dto.outgoing.TransactionDetails;
import com.pocketlog.pocketlog.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public void saveNewTransaction(TransactionCreation transactionCreation) {
        Transaction newTransaction = transactionRepository.save(new Transaction(transactionCreation));
    }

    public List<TransactionDetails> listAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        transactions.removeIf(Transaction::isDeleted);
        return transactions.stream().map(TransactionDetails::new).collect(Collectors.toList());
    }

    public void deleteTransactionById(Long id) {
        Transaction transaction = transactionRepository.getReferenceById(id);
        if (!transaction.isDeleted()) {
            transaction.setDeleted(true);
        }
    }
}
