package santiagoczarny.store.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import santiagoczarny.store.entities.Role;
import santiagoczarny.store.entities.Status;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Role role;

    private String password;

    private Status status;

    private PersonDto person;

}
