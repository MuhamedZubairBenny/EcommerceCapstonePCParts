package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Brand;
import za.ac.cput.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
