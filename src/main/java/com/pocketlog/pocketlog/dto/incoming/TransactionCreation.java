package com.pocketlog.pocketlog.dto.incoming;

import com.pocketlog.pocketlog.domain.enums.TransactionType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TransactionCreation {

    private TransactionType type;

    private double amount;

    private String description;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate transactionDate;
}
