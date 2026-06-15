package SRP;

public class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Invoice Amount: $" + invoice.getAmount());
    }
}
