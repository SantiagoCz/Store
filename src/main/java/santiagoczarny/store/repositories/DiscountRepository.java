package santiagoczarny.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santiagoczarny.store.entities.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
