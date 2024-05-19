package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Contact;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    Cart findByCartId(String cartId);
}
