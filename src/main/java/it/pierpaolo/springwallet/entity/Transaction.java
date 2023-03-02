package it.pierpaolo.springwallet.entity;

import it.pierpaolo.springwallet.constant.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSequenceGenerator")
    @SequenceGenerator(name = "transactionSequenceGenerator", sequenceName = "TRANSACTION_SEQUENCE", allocationSize = 100)
    private long id;

    @Column(name = "TYPE")
    private TransactionType type;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "NOTE")
    private String note;

    @Column(name="TRANSACTION_DATE")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
