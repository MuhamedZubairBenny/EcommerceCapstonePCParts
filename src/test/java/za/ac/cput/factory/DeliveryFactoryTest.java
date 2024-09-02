package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryFactoryTest {

    @Test
    void buildDelivery() {
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        Shipping shipping = ShippingFactory.buildShipping("Ship01","109 Bridge Street", "Manchester", "Tea", "4200", "England");
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart("01", productList);

        Customer customer = new CustomerFactory().buildCustomer("Cust01","ID10", "Zubair", "Benny", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        System.out.println(orderItem);
        Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);

        Delivery delivery = DeliveryFactory.buildDelivery("123",customer,order,payment,"01/06/2024","05/06/2024");
        assertNotNull(delivery);
        System.out.println(delivery);
    }

    @Test
    void buildDeliveryGenerateId() {
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        Shipping shipping = ShippingFactory.buildShipping("Ship01","109 Bridge Street", "Manchester", "Tea", "4200", "England");
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart("01", productList);
        Customer customer = new CustomerFactory().buildCustomer("Cust01","ID10", "Zubair", "Benny", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        System.out.println(orderItem);
        Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);

        Delivery delivery = DeliveryFactory.buildDelivery(customer,order,payment,"01/06/2024","05/06/2024");
        assertNotNull(delivery);
        System.out.println(delivery);
    }

    @Test
    void buildDeliveryFail(){
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        Shipping shipping = ShippingFactory.buildShipping("Ship01","109 Bridge Street", "Manchester", "Tea", "4200", "England");
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart("01", productList);
        Customer customer = new CustomerFactory().buildCustomer("Cust01","ID10", "Zubair", "Benny", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        System.out.println(orderItem);
        Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);

        Delivery delivery = DeliveryFactory.buildDelivery("",customer,order,payment,"01/06/2024","05/06/2024");
        assertNotNull(delivery);
        System.out.println(delivery);
    }
}