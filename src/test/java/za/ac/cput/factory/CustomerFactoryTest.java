package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerFactoryTest {

    @Test
    @Order(1)
    void buildCustomerWithObject() {
        //Build Contact
        Contact contact  = new ContactFactory().buildContact("zbenny@gmail.com","021 112 3345", "29 Bundu Street", "Cape Town", "Western Cape", "7345","South Africa");
        assertNotNull(contact);
        System.out.println(contact);

        //Build Customer
        Customer customer = new CustomerFactory().buildCustomer("01","Muhamed","Zubair", "123", contact);
        assertNotNull(customer);
        System.out.println(customer);
    }

    @Test
    @Order(2)
    void BuildCustomerWithStringContact() {
        Customer customer = new CustomerFactory().buildCustomer("02", "Duane", "Prins", "321", "dprins@gmail.com", "012 345 6789", "70 Jabrone Boulevard", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(customer);
        System.out.println(customer);
    }

    @Test
    @Order(3)
    void buildCustomerWithObjectFail() {
        //Build Contact
        Contact contact  = new ContactFactory().buildContact("zbennygmail.com","021 112 3345", "29 Bundu Street", "Cape Town", "Western Cape", "7345","South Africa");
        assertNotNull(contact);
        System.out.println(contact);
        //Build Customer
        Customer customer = new CustomerFactory().buildCustomer("01","Muhamed","Zubair", "123", contact);
        assertNotNull(customer);
        System.out.println(customer);
    }

    @Test
    @Order(4)
    void BuildCustomerWithStringFail() {
        Customer customer = new CustomerFactory().buildCustomer("02", "Duane", "Prins", "321", "dprinsgmail.com", "098 765 4321", "70 Jabrone Boulevard", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(customer);
        System.out.println(customer);
    }
}