package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRepositoryTest {
    private static ICustomerRepository repository = CustomerRepository.getRepository();
    private Contact contact = ContactFactory.buildContact("zbenny@gmail.com", "012 345 6789", "21 Savage Street", "Cape Town", "Western Cape", "7222", "South Africa");
    private Customer customer = CustomerFactory.buildCustomer("001", "Zubair", "Benny", "123",contact);

    @Test
    @Order(1)
    void create() {
        Customer created = repository.create(customer);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String customerId = "001";
        Customer read = repository.read(customerId);
        assertEquals(read, customer);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Customer updated = repository.update(new Customer.Builder().copy(customer).setFirstName("Muhamed Zubair").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(customer.getCustomerId()));
        System.out.println("Success: Deleted customer");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(repository.getAll());
    }
}