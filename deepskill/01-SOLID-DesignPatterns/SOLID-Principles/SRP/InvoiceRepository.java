package SRP;

public class InvoiceRepository {
    public void saveToDatabase(Invoice invoice) {
        System.out.println("Saving invoice of $" + invoice.getAmount() + " to DB");
    }
}
