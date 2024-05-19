package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactServiceTest {
    @Autowired
    private ContactService contactService;
    private static Contact contact1;
    private static Contact contact2;

    @Test
    void a_setup(){
        contact1 = ContactFactory.buildContact("zbenny@gmail.com","012 345 6789", "21 Jump Street", "Cape Town" ,"Western Cape" , "7540", "South Africa");
        assertNotNull(contact1);
        System.out.println(contact1);
        contact2 = ContactFactory.buildContact("dprins@gmail.com","098 765 4321", "40 Champion Street", "Cape Town" ,"Western Cape" , "7607", "South Africa");
        assertNotNull(contact2);
        System.out.println(contact2);
    }
    @Test
    void b_create() {
        Contact created1 = contactService.create(contact1);
        assertNotNull(created1);
        System.out.println(created1);
        Contact created2 = contactService.create(contact2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Contact read = contactService.read(contact1.getEmail());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Contact newContact = new Contact.Builder().copy(contact1).setCity("Johannesburg").build();
        Contact updated = contactService.update(newContact);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_getAll() {
        System.out.println(contactService.getAll());
    }
}