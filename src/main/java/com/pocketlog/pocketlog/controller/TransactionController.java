package com.pocketlog.pocketlog.controller;

import com.pocketlog.pocketlog.dto.incoming.TransactionCreation;
import com.pocketlog.pocketlog.dto.outgoing.TransactionDetails;
import com.pocketlog.pocketlog.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> addTransaction(@RequestBody TransactionCreation transaction) {
        transactionService.saveNewTransaction(transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDetails>> getAllTransactions() {
        List<TransactionDetails> listTransactions = transactionService.listAllTransactions();
        return new ResponseEntity<>(listTransactions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") Long id) {
        transactionService.deleteTransactionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
