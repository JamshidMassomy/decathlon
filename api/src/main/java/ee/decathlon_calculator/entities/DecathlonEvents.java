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
@Table(name = "decathlon_events")
public class DecathlonEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;

    @Enumerated(EnumType.STRING)
    @Column(name = "sport")
    private Sport sport;

    @Column(name = "coefficient_a")
    private BigDecimal coefficientA;

    @Column(name = "coefficient_b")
    private BigDecimal coefficientB;

    @Column(name = "coefficient_c")
    private BigDecimal coefficientC;
}