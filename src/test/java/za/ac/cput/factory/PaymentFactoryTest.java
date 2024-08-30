package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentFactoryTest {

    @Test
    void a_buildPaymentWithValidInput() {
        Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
        Customer customer = CustomerFactory.buildCustomer("001","Mark","Stevens","Qw123",contact);
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");

        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void b_buildPaymentWithGeneratedId() {
        Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
        Customer customer = CustomerFactory.buildCustomer("001","Mark","Stevens","Qw123",contact);
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");

        Order order = OrderFactory.buildOrder(14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        Payment payment = PaymentFactory.buildPayment(customer,order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void c_buildPaymentWithInvalidInput() {
        Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
        Customer customer = CustomerFactory.buildCustomer("001","Mark","Stevens","Qw123",contact);
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");

        Order order = OrderFactory.buildOrder("", 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        Payment payment = PaymentFactory.buildPayment("",customer,order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }
}
