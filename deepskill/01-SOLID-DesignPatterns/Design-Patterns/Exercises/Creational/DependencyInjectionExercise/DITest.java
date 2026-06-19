package Exercises.Creational.DependencyInjectionExercise;

public class DITest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        System.out.println(service.getCustomer("CUST1001"));
    }
}
