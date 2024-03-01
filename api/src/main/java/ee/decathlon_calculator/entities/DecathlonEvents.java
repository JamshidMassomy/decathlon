package ee.decathlon_calculator.entities;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_of_measure")
    private UnitOfMeasure unitOfMeasure;

    @Column(name = "coefficient_a")
    private Double coefficientA;

    @Column(name = "coefficient_b")
    private Double coefficientB;

    @Column(name = "coefficient_c")
    private Double coefficientC;
}