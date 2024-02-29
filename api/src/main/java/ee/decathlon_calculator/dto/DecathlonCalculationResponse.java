package ee.decathlon_calculator.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class DecathlonCalculationResponse {
    private Integer result;
}
