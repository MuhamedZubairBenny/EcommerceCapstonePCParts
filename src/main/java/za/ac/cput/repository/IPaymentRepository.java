package za.ac.cput.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Payment;

import java.util.List;

public interface IPaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> getAll();
}
