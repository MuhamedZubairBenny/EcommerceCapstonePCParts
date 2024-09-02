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
        Customer customer = new CustomerFactory().buildCustomer("Cust01","ID10", "Zubair", "Benny", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",p,1,order);
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        orderItemList.add(orderItem);

        Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);
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
        Customer customer = new CustomerFactory().buildCustomer("Cust01","ID10", "Zubair", "Benny", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",p,1,order);
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        orderItemList.add(orderItem);

        Payment payment = PaymentFactory.buildPayment(customer,order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void c_buildPaymentWithInvalidInput() {
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);
        Customer customer = new CustomerFactory().buildCustomer("Cust01","ID10", "Zubair", "Benny", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",p,1,order);
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        orderItemList.add(orderItem);

        Payment payment = PaymentFactory.buildPayment("",customer,order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }
}
