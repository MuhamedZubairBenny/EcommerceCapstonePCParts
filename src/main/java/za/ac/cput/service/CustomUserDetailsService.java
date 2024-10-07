//package za.ac.cput.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import za.ac.cput.domain.Customer;
//import za.ac.cput.repository.CustomerRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private CustomerRepository customerRepository;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Customer customer = customerRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + email));
//        return new org.springframework.security.core.userdetails.User(
//                customer.getEmail(),
//                customer.getPassword(),
//                true, // accountNonExpired
//                true, // accountNonLocked
//                true, // credentialsNonExpired
//                true, // enabled
//                AuthorityUtils.createAuthorityList(customer.getRole()));
//
//    }
//}
