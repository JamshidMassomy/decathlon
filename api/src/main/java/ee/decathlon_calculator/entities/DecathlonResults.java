package ee.decathlon_calculator.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

@Builder
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "unitOfMeasure"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DecathlonResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isCalculated;

    @Enumerated(EnumType.STRING)
    private UnitOfMeasure unitOfMeasure;
    private BigDecimal point;
}
