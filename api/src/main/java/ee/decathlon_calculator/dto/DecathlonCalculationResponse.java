package ee.decathlon_calculator.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DecathlonCalculationResponse {
    private final float result;
}
