package com.evanco.invoiceservice.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Invoice implements Serializable {

    protected int invoiceId;

    // wrapper and not primitive int to validate if supplied
    @NotNull(message = "Please supply a customer id.")
    @Positive
    protected Integer customerId;

    // will be auto generated by code, not supplied by user
    protected LocalDate purchaseDate;

    // constructors

    public Invoice() {
    }

    public Invoice(int invoiceId, Integer customerId, LocalDate purchaseDate) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.purchaseDate = purchaseDate;
    }

    // getters and setters

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    // override methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getInvoiceId() == invoice.getInvoiceId() &&
                Objects.equals(getCustomerId(), invoice.getCustomerId()) &&
                Objects.equals(getPurchaseDate(), invoice.getPurchaseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getCustomerId(), getPurchaseDate());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", customerId=" + customerId +
                ", purchaseDate=" + purchaseDate +
                '}';
    }

}