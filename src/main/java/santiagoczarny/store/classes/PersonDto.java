package santiagoczarny.store.classes;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import santiagoczarny.store.entities.Status;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @NotNull(message = "DNI cannot be empty")
    @Pattern(regexp = "\\d{8}", message = "DNI must have 8 digits")
    private String dni;

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "\\d{1,11}", message = "Phone number must have between 1 and 11 digits")
    private String phoneNumber;

    @NotNull(message = "Date of birth cannot be empty")
    @Past(message = "Date of birth must be a past date")
    private LocalDate dateOfBirth;

    private Status status;

}
