package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserFactoryTest {

    @Test
    @Order(1)
    void builduser() {
        //Build Shipping
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);

        //Build Cart
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);
        System.out.println(cart);
        za.ac.cput.domain.Order order = OrderFactory.buildOrder(100);
        System.out.println(order);
        Payment payment = PaymentFactory.buildPayment(order,"credit card", 100);
        System.out.println(payment);

        //Build User
        User user = UserFactory.buildUser( 2647L,"Bob", "McDonald", "bm@gmail.com", "12345", "111 121 1111", LocalDate.of(2000,1, 1), shipping, cart, payment);
        assertNotNull(user);
        System.out.println(user);
    }

    @Test
    @Order(2)
    void testBuilduser() {
        User user = UserFactory.buildUser("Jeoff", "Beezels", "jb@gmail.com", "12345");
        assertNotNull(user);
        System.out.println(user);
    }
}