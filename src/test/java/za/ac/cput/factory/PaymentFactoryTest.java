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
        Delivery delivery = DeliveryFactory.buildDelivery("05-03-2024", "10-03-2024");
        OrderItem orderItem = OrderItemFactory.buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
                , 2);
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        orderItemList.add(orderItem);
        Order order = OrderFactory.buildOrder("001",1000.00,delivery,customer,orderItemList);
        Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void b_buildPaymentWithGeneratedId() {
        Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
        Customer customer = CustomerFactory.buildCustomer("001","Mark","Stevens","Qw123",contact);
        Delivery delivery = DeliveryFactory.buildDelivery("05-03-2024", "10-03-2024");
        OrderItem orderItem = OrderItemFactory.buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
                , 2);
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        orderItemList.add(orderItem);
        Order order = OrderFactory.buildOrder("001",1000.00,delivery,customer,orderItemList);
        Payment payment = PaymentFactory.buildPayment("Credit card",customer,order,1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void c_buildPaymentWithInvalidInput() {
        Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
        Customer customer = CustomerFactory.buildCustomer("001","Mark","Stevens","Qw123",contact);
        Delivery delivery = DeliveryFactory.buildDelivery("05-03-2024", "10-03-2024");
        OrderItem orderItem = OrderItemFactory.buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
                , 2);
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        orderItemList.add(orderItem);
        Order order = OrderFactory.buildOrder("001",1000.00,delivery,customer,orderItemList);
        Payment payment = PaymentFactory.buildPayment("",customer,order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }
}
