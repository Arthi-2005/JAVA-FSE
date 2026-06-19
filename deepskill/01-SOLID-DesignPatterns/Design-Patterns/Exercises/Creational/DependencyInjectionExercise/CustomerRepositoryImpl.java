package Exercises.Creational.DependencyInjectionExercise;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        return "Customer details for ID: " + id;
    }
}
