package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemFactoryTest {

    @Test
    void buildOrderItem() {
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");

        Customer customer1 = CustomerFactory.buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa");
        Order order = OrderFactory.buildOrder("001", 14500.00,customer1);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        System.out.println(orderItem);
}
    @Test
    void buildOrderItemGeneratedId() {
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");

        Customer customer1 = CustomerFactory.buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa");
        Order order = OrderFactory.buildOrder("001", 14500.00,customer1);
        OrderItem orderItem = OrderItemFactory.buildOrderItem(product,1,order);
        System.out.println(orderItem);
    }

    @Test
    void buildOrderItemFail() {
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");

        Customer customer1 = CustomerFactory.buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa");
        Order order = OrderFactory.buildOrder("001", 14500.00,customer1);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("", product,1,order);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        assertNotNull(orderItem);
        System.out.println(orderItems);
    }

}