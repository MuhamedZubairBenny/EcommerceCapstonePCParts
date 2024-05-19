package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    private static Contact contact1;
    private static Contact contact2;
    private static Customer customer1;
    private static Customer customer2;

    @Test
    void a_setup(){
        contact1 = ContactFactory.buildContact("zbenny@gmail.com","012 345 6789", "21 Jump Street", "Cape Town" ,"Western Cape" , "7540", "South Africa");
        customer1 = CustomerFactory.buildCustomer("01","Zubair", "Benny", "123", contact1);
        assertNotNull(customer1);
        contact2 = ContactFactory.buildContact("dprins@gmail.com","098 765 4321", "40 Champion Street", "Cape Town" ,"Western Cape" , "7607", "South Africa");
        customer2 = CustomerFactory.buildCustomer("02","Duane", "Prins", "321", contact2);
        assertNotNull(customer2);
    }
    @Test
    void b_create() {
        Customer created1 = customerService.create(customer1);
        assertNotNull(created1);
        System.out.println(created1);
        Customer created2 = customerService.create(customer2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Customer read = customerService.read(customer1.getCustomerId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Customer newCustomer = new Customer.Builder().copy(customer1).setFirstName("Muhamed Zubair").build();
        Customer updatedCustomer = customerService.update(newCustomer);
        assertNotNull(updatedCustomer);
        System.out.println(updatedCustomer);
    }

    @Test
    @Disabled
    void e_delete(){
        customerService.delete(customer2.getCustomerId());
    }
    @Test
    void f_getAll() {
        System.out.println(customerService.getAll());
    }
}