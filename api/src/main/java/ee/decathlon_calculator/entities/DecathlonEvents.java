package ee.decathlon_calculator.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

@Builder
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "eventType"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DecathlonEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Enumerated(EnumType.STRING)
    private Sport sport;

    private BigDecimal coefficientA;
    private BigDecimal coefficientB;
    private BigDecimal coefficientC;

}