package ee.decathlon_calculator.services;

import ee.decathlon_calculator.entities.DecathlonEvents;
import ee.decathlon_calculator.entities.EventType;
import ee.decathlon_calculator.entities.Sport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {

    @InjectMocks
    private CalculationService calculationService;

    @Test
    void test_should_return_correct_long_jump_point() {
        int expectedPoint = 1000;
        DecathlonEvents longJump = DecathlonEvents.
                builder()
                .eventType(EventType.JUMP_EVENT)
                .sport(Sport.LONG_JUMP)
                .coefficientA(0.14354)
                .coefficientB(220.0)
                .coefficientC(1.4)
                .build();
        double result = 7.76;

        // act
        int actualPoint = calculationService.calculateJumpEvent(longJump, result);

        // assert
        assertThat(actualPoint).isEqualTo(expectedPoint);
    }

    @Test
    void test_should_return_correct_100_meter_point() {
        int expectedPoint = 900;
        DecathlonEvents aSport = DecathlonEvents.
                builder()
                .eventType(EventType.TRACK_EVENT)
                .sport(Sport.ONE_HUNDRED_METER)
                .coefficientA(25.4347)
                .coefficientB(18.0)
                .coefficientC(1.81)
                .build();
        double result = 10.827;

        // act
        int actualPoint = calculationService.calculateTrackEvent(aSport, result);

        // assert
        assertThat(actualPoint).isEqualTo(expectedPoint);
    }


    @Test
    void test_should_return_correct_shot_put_point() {
        int expectedPoint = 700;
        DecathlonEvents aSport = DecathlonEvents.
                builder()
                .eventType(EventType.THROW_EVENT)
                .sport(Sport.SHOT_PUT)
                .coefficientA(51.39)
                .coefficientB(1.5)
                .coefficientC(1.05)
                .build();
        double result = 13.53;

        // act
        int actualPoint = calculationService.calculateThrowEvent(aSport, result);

        // assert
        assertThat(actualPoint).isEqualTo(expectedPoint);
    }

    @Test
    void discus_throw_calculation_point_test() {
        // arrange
        double result = 46.59;
        int expectedResult = 800;
        DecathlonEvents discusThrow = DecathlonEvents.
                builder()
                .eventType(EventType.THROW_EVENT)
                .sport(Sport.DISCUS_THROW)
                .coefficientA(12.91)
                .coefficientB(4.0)
                .coefficientC(1.1)
                .build();

        // act
        int actualPoint = calculationService.calculateThrowEvent(discusThrow, result);

        // assert
        assertThat(actualPoint).isEqualTo(expectedResult);

    }
}
