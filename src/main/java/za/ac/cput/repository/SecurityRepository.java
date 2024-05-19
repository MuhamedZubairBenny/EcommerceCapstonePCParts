package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Security;
@Repository
public interface SecurityRepository extends JpaRepository<Security, String> {
    Security findByUsername(String username);
}

