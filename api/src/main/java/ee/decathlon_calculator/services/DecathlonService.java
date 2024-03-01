package ee.decathlon_calculator.services;

import ee.decathlon_calculator.dto.DecathlonCalculationResponse;
import ee.decathlon_calculator.entities.DecathlonEvents;
import ee.decathlon_calculator.exceptions.BusinessException;
import ee.decathlon_calculator.repositories.DecathlonRepository;
import ee.decathlon_calculator.entities.Sport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static ee.decathlon_calculator.utils.Constants.EVENT_NOT_FOUND;
import static ee.decathlon_calculator.utils.Constants.UNSUPPORTED_EVENT_TYPE;

@Service
@RequiredArgsConstructor
@Slf4j
public final class DecathlonService {

    private final DecathlonRepository decathlonRepository;
    private final CalculationService calculationService;

    public DecathlonCalculationResponse getPointCalculation(final Sport sport, final Double result) {
        int calculatePoints = calculatePoints(sport, result);
        return DecathlonCalculationResponse.builder()
                .point(calculatePoints)
                .build();
    }

    private DecathlonEvents getDecathlonEvent(Sport sport) {
        return decathlonRepository.findBySport(sport)
                .orElseThrow(() -> new BusinessException(EVENT_NOT_FOUND));
    }

    private int calculatePoints(Sport sport, Double point) {
        DecathlonEvents event = getDecathlonEvent(sport);
        log.info("calculating event - {} and sport - {}", event.getEventType(), event.getSport());
            switch (event.getEventType()) {
                case JUMP_EVENT -> {
                    return calculationService.calculateJumpEvent(event, point);
                }
                case TRACK_EVENT -> {
                    return calculationService.calculateTrackEvent(event, point);
                }
                case THROW_EVENT -> {
                    return calculationService.calculateThrowEvent(event, point);
                }
                default -> throw new BusinessException(UNSUPPORTED_EVENT_TYPE + event.getEventType());
            }
    }
}