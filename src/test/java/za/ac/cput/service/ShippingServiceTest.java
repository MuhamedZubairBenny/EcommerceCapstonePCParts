package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Shipping;
import za.ac.cput.factory.BrandFactory;
import za.ac.cput.factory.ShippingFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ShippingServiceTest {
    @Autowired
    private ShippingService shippingService;
    private static Shipping shipping;


    @BeforeAll
    static void a_setup(){
        shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
    }
    @Test
    void b_create() {
        Shipping created = shippingService.create(shipping);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void c_read() {
        Shipping read = shippingService.read(shipping.getShippingId());
        assertNotNull(read);
        System.out.println(read);

    }

    @Test
    void d_update() {
        Shipping newShipping = new Shipping.Builder().copy(shipping).setCity("Sukuna").build();
        Shipping updated = shippingService.update(newShipping);
        assertNotNull((updated));
        System.out.println(updated);
    }

    @Test
    @Disabled
    void e_delete() {
        shippingService.delete(shipping.getShippingId());
    }

    @Test
    void f_getAll() {
        System.out.println(shippingService.getAll());
    }
}