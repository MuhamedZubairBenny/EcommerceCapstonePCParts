package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DeliveryRepositoryTest {

    private static IDeliveryRepository repository = DeliveryRepository.getRepository();
    private Contact contact = ContactFactory.buildContact("zbenny@gmail.com", "012 345 6789", "21 Savage Street", "Cape Town", "Western Cape", "7222", "South Africa");
    private Customer customer = CustomerFactory.buildCustomer("001", "Zubair", "Benny", "123",contact);
    OrderItem orderItem = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 10000.00, "Sapphire Pure AMD Radeon RX 7700"
            , 1);
    //This is a list
    private static List<OrderItem> orderItemList = new ArrayList<OrderItem>();{orderItemList.add(orderItem);}
    private Order order = OrderFactory.buildOrder("001", 14500.00,customer,orderItemList);
    Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);

    private Delivery delivery = DeliveryFactory.buildDelivery("100",customer,order,payment,"01/06/2024","05/06/2024");
    @Test
    void a_create() {
        Delivery created = repository.create(delivery);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        String deliveryId = "100";
        Delivery read = repository.read(deliveryId);
        assertEquals(read,delivery);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Delivery updated = repository.update(new Delivery.Builder().copy(delivery).setTransitDate("10/06/2024").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_delete() {
        assertTrue(repository.delete(delivery.getDeliveryId()));
        System.out.println("Success: Delete customer");
    }

    @Test
    void d_getAll() {
        System.out.println(repository.getAll());
    }
}