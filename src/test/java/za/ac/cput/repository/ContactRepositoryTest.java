package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactRepositoryTest {
    private static IContactRepository repository = ContactRepository.getRepository();
    private Contact contact = ContactFactory.buildContact("zubairbenny@gmail.com", "012 345 6789", "21 Savage Street", "Cape Town", "Western Cape", "7224", "South Africa");

    @Test
    @Order(1)
    void create() {
        Contact created = repository.create(contact);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String email = "zubairbenny@gmail.com";
        Contact read = repository.read(email);
        assertEquals(read, contact);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Contact updated = repository.update(new Contact.Builder().copy(contact).setAddress("22 Jump Street").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(6)
    void delete() {
        assertTrue(repository.delete(contact.getEmail()));
        System.out.println("Success: Deleted contact");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(repository.getAll());
    }
}