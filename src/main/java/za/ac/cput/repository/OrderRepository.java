package za.ac.cput.repository;



import za.ac.cput.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private static IOrderRepository repository = null;
    private List<Order> orderList;
    private OrderRepository(){orderList = new ArrayList<Order>();}
    public static IOrderRepository getRepository(){
        if(repository == null){
            repository = new OrderRepository();
        }
        return repository;
    }

    @Override
    public Order create(Order order) {
        boolean success = orderList.add(order);
        if(success)
            return order;
        return null;
    }

    @Override
    public Order read(String orderId){
        for(Order o : orderList){
            if(o.getOrderId().equals(orderId))
                return o;
        }
        return null;
    }

    @Override
    public Order update(Order order){
        Order orderOld = read(order.getOrderId());
        boolean success = orderList.remove(orderOld);
        if(success){
            if(orderList.add(order))
                return order;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
       Order OrderToDelete = read(s);
        boolean success = orderList.remove(OrderToDelete);
        return success;
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }
}


