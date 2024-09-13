package santiagoczarny.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santiagoczarny.store.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
