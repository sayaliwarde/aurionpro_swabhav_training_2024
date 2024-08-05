package com.aurionpro.srp.violation.test;

import com.aurionpro.srp.violation.model.Invoice;
import com.aurionpro.srp.violation.model.InvoicePrinter;
import com.aurionpro.srp.violation.model.TaxCalculator;

public class InvoiceTest {
	public static void main(String[] args) {

		Invoice invoice=new Invoice("abc", "duhd", 2157, 0.10); 	
        TaxCalculator taxCalculator = new TaxCalculator(invoice);
        InvoicePrinter invoicePrinter = new InvoicePrinter(invoice, taxCalculator);
                
        invoicePrinter.displayInvoice();
	}

}
