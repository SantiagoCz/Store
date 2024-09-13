package santiagoczarny.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santiagoczarny.store.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}