package com.finance.dashboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
public class FinancialRecord {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Positive
    private double amount;

    @Enumerated(EnumType.STRING)
    private RecordType type;

    private String category;
    private String description;
    private String date;

    @ManyToOne
    private User user;
}
