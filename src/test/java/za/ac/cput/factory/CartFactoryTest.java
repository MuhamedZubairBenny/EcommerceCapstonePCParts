package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Cart;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartFactoryTest {

    @Test
    @Order(1)
    void buildCartWithObject() {
        Cart cart = new CartFactory().buildCart("001", "001", "GPU",  1000.00);
        assertNotNull(cart);
        System.out.println(cart);
    }

    @Test
    @Order(2)
    void buildCartWithStringContact() {
        Cart cart = new CartFactory().buildCart("002", "002", "", 1500.00);
        assertNotNull(cart);
        System.out.println(cart);
    }

    @Test
    @Order(3)
    void buildCartWithObjectFail() {
        Cart cart = new CartFactory().buildCart("003", " 003 ", " CPU  ", 1500.00);
        assertNotNull(cart);
        System.out.println(cart);
    }

    @Test
    @Order(4)
    void buildCartWithStringFail() {
        Cart cart = new CartFactory().buildCart("004", "004", "Cooling fan", 1500.00);
        assertNotNull(cart);
        System.out.println(cart);
    }
}
