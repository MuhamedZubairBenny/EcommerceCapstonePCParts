package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ContactRepository;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    private CustomerRepository repository;
    private ContactRepository contactRepository;

    @Autowired
    CustomerService(CustomerRepository repository, ContactRepository contactRepository){
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    @Override
    public Customer create(Customer customer) {
       // contactRepository.save(customer.getContact());
        return repository.save(customer);}

    @Override
    public Customer read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
       // contactRepository.save(customer.getContact());
        return repository.save(customer);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }
}
