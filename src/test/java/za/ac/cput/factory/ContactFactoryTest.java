package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactFactoryTest {

    @Test
    @Order(1)
    void buildContact() {
        Contact contact = ContactFactory.buildContact("zbenny@gmail.com","012 345 6789", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(contact);
        System.out.println(contact);

    }

    @Test
    @Order(2)
    void buildContactWithFail() {
        Contact contact = ContactFactory.buildContact("zbennygmailcom","012 345 6789", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(contact);
        System.out.println(contact);
    }
}