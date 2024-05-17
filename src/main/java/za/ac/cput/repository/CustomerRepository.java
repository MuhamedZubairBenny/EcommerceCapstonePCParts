package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    private static ICustomerRepository repository = null;
    private List<Customer> customerList;
    private CustomerRepository() {customerList = new ArrayList<Customer>();}
    public static ICustomerRepository getRepository(){
        if (repository == null){
            repository = new CustomerRepository();
        }
        return repository;
    }
    @Override
    public Customer create(Customer customer) {
        boolean success = customerList.add(customer);
        if (success)
            return customer;
        return null;
    }

    @Override
    public Customer read(String id) {
        for (Customer c : customerList){
            if (c.getCustomerId().equals(id))
                return c;
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        Customer customerOld = read(customer.getCustomerId());

        boolean success = customerList.remove(customerOld);
        if (success){
            if (customerList.add(customer))
                return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Customer customerToDelete = read(id);
        boolean success = customerList.remove(customerToDelete);
        return success;
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
