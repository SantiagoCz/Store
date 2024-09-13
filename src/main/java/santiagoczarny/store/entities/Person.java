package santiagoczarny.store.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "DNI cannot be empty")
    @Pattern(regexp = "\\d{8}", message = "DNI must have 8 digits")
    @Column(length = 8, unique = true)
    private String dni;

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "\\d{1,11}", message = "Phone number must have between 1 and 11 digits")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull(message = "Date of birth cannot be empty")
    @Past(message = "Date of birth must be a past date")
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Column(name = "status")
    private Status status;

//    @OneToOne(mappedBy = "person")
//    private Customer customer;

}

