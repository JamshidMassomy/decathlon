package ee.decathlon_calculator.services;

import ee.decathlon_calculator.dto.DecathlonCalculationResponse;
import ee.decathlon_calculator.entities.DecathlonEvents;
import ee.decathlon_calculator.repositories.DecathlonRepository;
import ee.decathlon_calculator.entities.Sport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class DecathlonService {
    private final DecathlonRepository decathlonRepository;
    public DecathlonCalculationResponse getCalculations(Sport sport, BigDecimal point) {
        int calculationResult = calculatePoints(sport, point);
        return DecathlonCalculationResponse.builder()
                .result(calculationResult)
                .build();
    }
    private int calculatePoints(Sport sport, BigDecimal point) {
        DecathlonEvents event = decathlonRepository.findBySport(Objects.requireNonNull(sport));
        log.info("calculating event - {} and sport - {}", event.getEventType(), event.getSport());
        switch (event.getEventType()) {
            case FIELD -> {
                return calculateFieldEventScore(event, point);
            }
            case TRACK -> {
                return calculateTrackEvent(event, point);
            }
            default -> throw new IllegalStateException("Unsupported event type: " + event.getEventType());
        }
    }

    /**
     * @Parm Event
     * @Parm Point
     * @Formula INT(A(P — B)C)
     * */
    private int calculateFieldEventScore(DecathlonEvents event, BigDecimal point) {
        int coefficientC = event.getCoefficientC().intValue();
        BigDecimal coefficientA = event.getCoefficientA();
        BigDecimal coefficientB = event.getCoefficientB();
        BigDecimal result = coefficientA.multiply(point.subtract(coefficientB).pow(coefficientC));
        return result.setScale(0, RoundingMode.HALF_UP).intValue();
    }

    /**
     * @Parm Event
     * @Parm Point
     * @Formula INT(A(B — P)C)
     * */
    private int calculateTrackEvent(DecathlonEvents event, BigDecimal point) {
        int coefficientC = event.getCoefficientC().intValue();
        BigDecimal coefficientA = event.getCoefficientA();
        BigDecimal coefficientB = event.getCoefficientB();
        BigDecimal result = coefficientA.multiply(coefficientB.subtract(point).pow(coefficientC));
        return result.setScale(0, RoundingMode.HALF_UP).intValue();
    }

    private boolean isCalculationValid(Sport sport, DecathlonEvents event, BigDecimal point) {
        if (isResultValid(point)) {

        } else {
            log.error("Can not calculated due the missing validation");
        }
        // check 1: not calculated before for the same event
        // check 2: cofficent exists
        return false;
    }

    private boolean isResultValid(final BigDecimal result) {
        return result.compareTo(BigDecimal.ZERO) > 0;
    }
}
