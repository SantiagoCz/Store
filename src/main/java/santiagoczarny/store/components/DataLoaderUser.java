package santiagoczarny.store.components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import santiagoczarny.store.entities.AppUser;
import santiagoczarny.store.entities.Person;
import santiagoczarny.store.entities.Role;
import santiagoczarny.store.entities.Status;
import santiagoczarny.store.services.PersonService;
import santiagoczarny.store.services.UserService;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class DataLoaderUser {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PersonService personService;
    @Autowired
    private UserService userService;

    @PostConstruct
    public void loadData() {
        createUser();
    }

    public void createUser() {
        String dni = "12345678";

        Optional<Person> existingPersonOptional = personService.findPersonByDniOptional(dni);
        if (existingPersonOptional.isPresent()) {
            System.out.println("A person with the provided DNI already exists.");
            return;
        }

        Person person = Person.builder()
                .dni(dni)
                .firstName("Admin")
                .lastName("Admin")
                .dateOfBirth(LocalDate.of(1990, 1, 1))
                .phoneNumber("12345678910")
                .build();

        // Create and save the user
        AppUser user = AppUser.builder()
                .person(person)
                .password(passwordEncoder.encode("1234"))
                .role(Role.ADMIN)
                .status(Status.ACTIVE)
                .build();

        try {
            personService.save(person);
            userService.save(user);
            System.out.println("User created automatically: " + person.getFirstName());
        } catch (Exception e) {
            System.out.println("Error creating the user: " + e.getMessage());
        }
    }
}
