package santiagoczarny.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santiagoczarny.store.entities.Payment;
import santiagoczarny.store.entities.Person;
import santiagoczarny.store.entities.Status;
import santiagoczarny.store.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person){
        return personRepository.save(person);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public void delete(Person person){
        personRepository.delete(person);
    }

    public void deactivate(Person person) {
        person.setStatus(Status.INACTIVE);
        save(person);
    }

    public Optional<Person> findPersonByDniOptional(String dni) {
        return personRepository.findByDni(dni);
    }
}
