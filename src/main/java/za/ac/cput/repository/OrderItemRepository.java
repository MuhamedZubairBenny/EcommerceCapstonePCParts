package za.ac.cput.repository;


import za.ac.cput.domain.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemRepository implements IOrderItemRepository{
        private static IOrderItemRepository repository = null;
        private List<OrderItem> orderItemList;
        private OrderItemRepository(){orderItemList = new ArrayList<OrderItem>();}
        public static IOrderItemRepository getRepository(){
            if(repository == null){
                repository = new OrderItemRepository();
            }
            return repository;
        }

        @Override
        public OrderItem create(OrderItem orderItem) {
            boolean success = orderItemList.add(orderItem);
            if(success)
                return orderItem;
            return null;
            }

        @Override
        public OrderItem read(String itemId){
            for(OrderItem o : orderItemList){
                if(o.getItemId().equals(itemId))
                    return o;
            }
            return null;
        }

        @Override
        public OrderItem update(OrderItem orderItem){
            OrderItem orderItemOld = read(orderItem.getItemId());
            boolean success = orderItemList.remove(orderItemOld);
            if(success){
                if(orderItemList.add(orderItem))
                    return orderItem;
            }
            return null;
        }

        @Override
        public boolean delete(String s) {
            OrderItem OrderToDelete = read(s);
            boolean success = orderItemList.remove(OrderToDelete);
            return success;
        }

        @Override
        public List<OrderItem> getAll() {
            return orderItemList;
        }
    }


