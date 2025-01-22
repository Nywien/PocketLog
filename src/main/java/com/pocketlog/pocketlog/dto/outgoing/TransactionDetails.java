package com.pocketlog.pocketlog.dto.outgoing;

import com.pocketlog.pocketlog.domain.Transaction;
import com.pocketlog.pocketlog.domain.enums.TransactionType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TransactionDetails {

    private TransactionType type;

    private double amount;

    private String description;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate transactionDate;

    public TransactionDetails(Transaction transaction) {
        this.type = transaction.getType();
        this.amount = transaction.getAmount();
        this.description = transaction.getDescription();
        this.transactionDate = transaction.getTransactionDate();
    }
}
