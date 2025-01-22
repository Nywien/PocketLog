package com.pocketlog.pocketlog.domain;


import com.pocketlog.pocketlog.domain.enums.TransactionType;
import com.pocketlog.pocketlog.dto.incoming.TransactionCreation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransactionType type;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "transaction_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate transactionDate;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    public Transaction(TransactionCreation transaction) {
        this.type = transaction.getType();
        this.amount = transaction.getAmount();
        this.description = transaction.getDescription();
        this.transactionDate = transaction.getTransactionDate();
    }
}
