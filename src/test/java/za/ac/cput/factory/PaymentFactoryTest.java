package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentFactoryTest {

    @Test
    void a_buildPaymentWithValidInput() {
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);
        Order order = OrderFactory.buildOrder(101L, 14500.00, cart);
        User user = UserFactory.buildUser("Jeoff", "Beezels", "jb@gmail.com", "12345");
        assertNotNull(user);
        System.out.println(user);
        Payment payment = PaymentFactory.buildPayment(001L,user, order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void b_buildPaymentWithGeneratedId() {
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);
        Order order = OrderFactory.buildOrder(101L, 14500.00, cart);
        User user = UserFactory.buildUser("Jeoff", "Beezels", "jb@gmail.com", "12345");
        assertNotNull(user);
        System.out.println(user);
        Payment payment = PaymentFactory.buildPayment(user, order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }
}
