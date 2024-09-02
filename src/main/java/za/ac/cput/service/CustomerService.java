package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.dto.CustomerDto;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.ShippingRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    private CustomerRepository repository;
    private ShippingRepository shippingRepository;

    @Autowired
    CustomerService(CustomerRepository repository, ShippingRepository shippingRepository) {
        this.repository = repository;
        this.shippingRepository = shippingRepository;
    }
    public void register(CustomerDto customerDto) {
        Customer customer = CustomerFactory.buildCustomer(
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getPassword()
        );

        if (customer == null) {
            throw new IllegalArgumentException("Invalid customer data");
        }

        repository.save(customer);
    }
    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        shippingRepository.save(customer.getShipping());
        return repository.save(customer);
    }

    @Override
    public void delete(String id) {
        if (repository.existsById(id))
            repository.deleteById(id);
    }

    public Customer getCustomer(String email){
        return repository.findByEmail(email);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }
    public boolean verifyLogin(String email, String password){
        Optional<Customer> verifyCustomer = repository.findByEmailAndPassword(email, password);
        return verifyCustomer.isPresent();
    }
}
