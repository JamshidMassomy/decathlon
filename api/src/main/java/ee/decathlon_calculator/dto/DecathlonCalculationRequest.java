package ee.decathlon_calculator.dto;

import ee.decathlon_calculator.entities.Sport;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@RequiredArgsConstructor
public class DecathlonCalculationRequest {

    @NotNull(message = "Sport must not be null")
    private final Sport sport;

    @DecimalMin(value = "0", inclusive = false, message = "Result must not be zero")
    @DecimalMax(value = "90000", message = "Result must not be greater than 100")
    private final float result;
}
