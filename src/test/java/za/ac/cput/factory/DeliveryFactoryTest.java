//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class DeliveryFactoryTest {
//
//    @Test
//    void buildDelivery() {
//        OrderItem orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
//                , 2);
//        OrderItem orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 10000.00, "Sapphire Pure AMD Radeon RX 7700"
//                , 1);
//        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
//        orderItemList.add(orderItem1);
//        orderItemList.add(orderItem2);
//        Customer customer = new CustomerFactory().buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"
//                ," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa"  );
//        Order order = new OrderFactory().buildOrder("001", 14500.00,customer,orderItemList);
//        Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);
//
//        Delivery delivery = DeliveryFactory.buildDelivery("123",customer,order,payment,"01/06/2024","05/06/2024");
//        assertNotNull(delivery);
//        System.out.println(delivery);
//    }
//
//    @Test
//    void buildDeliveryGenerateId() {
//        OrderItem orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
//                , 2);
//        OrderItem orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 10000.00, "Sapphire Pure AMD Radeon RX 7700"
//                , 1);
//        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
//        orderItemList.add(orderItem1);
//        orderItemList.add(orderItem2);
//        Customer customer = new CustomerFactory().buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"
//                ," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa"  );
//        Order order = new OrderFactory().buildOrder("001", 14500.00,customer,orderItemList);
//        Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);
//
//        Delivery delivery = DeliveryFactory.buildDelivery(customer,order,payment,"01/06/2024","05/06/2024");
//        assertNotNull(delivery);
//        System.out.println(delivery);
//    }
//
//    @Test
//    void buildDeliveryFail(){
//        OrderItem orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
//                , 2);
//        OrderItem orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 10000.00, "Sapphire Pure AMD Radeon RX 7700"
//                , 1);
//        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
//        orderItemList.add(orderItem1);
//        orderItemList.add(orderItem2);
//        Customer customer = new CustomerFactory().buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"
//                ," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa"  );
//        Order order = new OrderFactory().buildOrder("001", 14500.00,customer,orderItemList);
//        Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);
//
//        Delivery delivery = DeliveryFactory.buildDelivery("",customer,order,payment,"01/06/2024","05/06/2024");
//        assertNotNull(delivery);
//        System.out.println(delivery);
//    }
//}