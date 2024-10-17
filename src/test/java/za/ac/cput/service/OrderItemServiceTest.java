//package za.ac.cput.service;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.domain.*;
//import za.ac.cput.domain.Order;
//import za.ac.cput.factory.*;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.MethodName.class)
//public class OrderItemServiceTest {
//    @Autowired
//    private OrderItemService orderItemService;
//    private static OrderItem orderItem;
//
//    private static Customer customer;
//    private static ProductCategory category;
//    private static Brand brand;
//    private static Product product;
//    private static Order order;
//    @BeforeAll
//    static void a_setup() {
//
//        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
//        assertNotNull(shipping);
//        System.out.println(shipping);
//        List<Product> productList = new ArrayList<>();
//        Cart cart = CartFactory.buildCart(productList);
//
//        //Build Customer
//        Customer customer = new CustomerFactory().buildCustomer("Cust02","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
//        assertNotNull(customer);
//        System.out.println(customer);
//        ProductCategory category = ProductCategoryFactory.buildProductCategory("02", "CPU");
//        Brand brand = BrandFactory.buildBrand("101", "AMD");
//        product = ProductFactory.buildProduct("001","Ryzen 5 5600X", category, brand, "Ryzen CPU", 3999.00, 23, "10cm", "2 years", "Ryzen5Products/Ryzen_5_5600.png");
//        order = OrderFactory.buildOrder("10", 15000);
//
//        orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
//        assertNotNull(orderItem);
//        System.out.println(orderItem);
//}
//    @Test
//    void b_create() {
//        OrderItem createdOrderItem1 = orderItemService.create(orderItem);
//        assertNotNull(createdOrderItem1);
//        System.out.println(createdOrderItem1);
//    }
//
//    @Test
//    void c_read() {
//        OrderItem read = orderItemService.read(orderItem.getItemId());
//        assertNotNull(read);
//        System.out.println(read);
//    }
//
//    @Test
//    void d_update() {
//        OrderItem newOrderItem = new OrderItem.Builder().copy(orderItem).setQuantity(5).build();
//        OrderItem updateOrderItem =orderItemService.update(newOrderItem);
//        assertNotNull(updateOrderItem);
//        System.out.println(updateOrderItem);
//    }
//
//    @Test
//    @Disabled
//    void e_delete() {
//        orderItemService.delete("100");
//    }
//
//    @Test
//    void f_getAll() {
//        System.out.println(orderItemService.getAll());
//    }
//}
