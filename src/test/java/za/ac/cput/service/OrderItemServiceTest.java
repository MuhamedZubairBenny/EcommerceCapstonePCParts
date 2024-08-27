package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderItemServiceTest {
    @Autowired
    private OrderItemService orderItemService;
    private static OrderItem orderItem;
    private static OrderItem orderItem2;
    private static Contact contact;
    private static Customer customer;
    private static ProductCategory category;
    private static Brand brand;
    private static Product product, product2;
    private static Order order;
    @Test
    void a_setup() {
        contact = ContactFactory.buildContact("zbenny@gmail.com","012 345 6789", "21 Jump Street", "Cape Town" ,"Western Cape" , "7540", "South Africa");
        customer = CustomerFactory.buildCustomer("01","Zubair", "Benny", "123", contact);
        ProductCategory category = ProductCategoryFactory.buildProductCategory("02", "CPU");
        Brand brand = BrandFactory.buildBrand("101", "AMD");
        product = ProductFactory.buildProduct("001","Ryzen 5 5600X", category, brand, "Ryzen CPU", 3999.00, 23, "10cm", "2 years", "Ryzen5Products/Ryzen_5_5600.png");
        order = OrderFactory.buildOrder("10", 15000, customer);

        orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        assertNotNull(orderItem);
        System.out.println(orderItem);
}
    @Test
    void b_create() {
        OrderItem createdOrderItem1 = orderItemService.create(orderItem);
        assertNotNull(createdOrderItem1);
        System.out.println(createdOrderItem1);
    }

    @Test
    void c_read() {
        OrderItem read = orderItemService.read(orderItem.getItemId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        OrderItem newOrderItem = new OrderItem.Builder().copy(orderItem).setQuantity(5).build();
        OrderItem updateOrderItem =orderItemService.update(newOrderItem);
        assertNotNull(updateOrderItem);
        System.out.println(updateOrderItem);
    }

    @Test
    void e_delete() {
        orderItemService.delete("100");
    }

    @Test
    void f_getAll() {
        System.out.println(orderItemService.getAll());
    }
}
