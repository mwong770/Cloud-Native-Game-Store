package com.company.invoiceservice.dao;

import com.company.invoiceservice.model.InvoiceItem;

import java.util.List;

public interface InvoiceItemDao {

    // standard CRUD

    InvoiceItem addInvoiceItem(InvoiceItem invoiceItem);

    InvoiceItem getInvoiceItem(int id);

    void updateInvoiceItem(InvoiceItem invoiceItem);

    void deleteInvoiceItem(int id);

    List<InvoiceItem> getAllInvoiceItems();

    // additional methods

    List<InvoiceItem> getInvoiceItemsByInvoiceId(int invoiceId);
}
