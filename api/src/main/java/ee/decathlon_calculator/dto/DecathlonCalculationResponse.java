package ee.decathlon_calculator.dto;

import lombok.*;


@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class DecathlonCalculationResponse {
    private Integer result;
}
