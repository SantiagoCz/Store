package santiagoczarny.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private Role role;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private Status status;

    // 1-1 RELATIONSHIP WITH PERSON
    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;

}

