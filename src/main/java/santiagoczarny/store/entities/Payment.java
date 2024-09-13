package santiagoczarny.store.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Positive(message = "The amount must be a positive number")
    @Column(name = "amount")
    private Double amount;

    @Column(name = "status")
    private Status status;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

}


