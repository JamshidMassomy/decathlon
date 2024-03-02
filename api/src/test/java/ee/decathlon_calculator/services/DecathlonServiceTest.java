package ee.decathlon_calculator.services;

import ee.decathlon_calculator.entities.DecathlonEvents;
import ee.decathlon_calculator.entities.EventType;
import ee.decathlon_calculator.entities.Sport;
import ee.decathlon_calculator.exceptions.BusinessException;
import ee.decathlon_calculator.repositories.DecathlonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DecathlonServiceTest {

    @InjectMocks
    private DecathlonService decathlonService;

    @Mock
    private CalculationService calculationService;

    @Mock
    private DecathlonRepository decathlonRepository;

    @Test
    void test_should_through_on_invalid_sport() {
        assertThrows(BusinessException.class, () -> decathlonService.getPointCalculation(null, 1.3));
        verifyNoInteractions(calculationService);
    }

    @Test
    void test_should_return_correct_result() {
        DecathlonEvents expectedEvent = DecathlonEvents.
                builder()
                .eventType(EventType.JUMP_EVENT)
                .sport(Sport.LONG_JUMP)
                .coefficientA(0.14354)
                .coefficientB(220.0)
                .coefficientC(1.4)
                .build();
       when(decathlonRepository.findBySport(Sport.LONG_JUMP)).thenReturn(Optional.ofNullable(expectedEvent));
       decathlonService.getPointCalculation(Sport.LONG_JUMP, 7.76);
       verify(calculationService, times(1)).calculateJumpEvent(expectedEvent, 7.76);
    }
}
