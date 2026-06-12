package SRP;

public class SRPDemo {
    public static void main(String[] args) {
        Invoice inv = new Invoice(1500);
        InvoicePrinter printer = new InvoicePrinter();
        InvoiceRepository repo = new InvoiceRepository();
        printer.print(inv);
        repo.saveToDatabase(inv);
    }
}
