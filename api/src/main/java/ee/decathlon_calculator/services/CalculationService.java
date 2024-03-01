package ee.decathlon_calculator.services;

import ee.decathlon_calculator.entities.DecathlonEvents;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public int calculateTrackEvent(DecathlonEvents event, Double result) {
        double coefficientC = event.getCoefficientC();
        double coefficientA = event.getCoefficientA();
        double coefficientB = event.getCoefficientB();
        double point = coefficientA * Math.pow((coefficientB - result), coefficientC);
        return (int) Math.round(point);
    }

    public int calculateJumpEvent(DecathlonEvents event, Double result) {
        double resultInCM = result * 100;
        return calculateEvent(event, resultInCM);
    }

    public int calculateThrowEvent(DecathlonEvents event, Double result) {
        return calculateEvent(event, result);
    }

    private int calculateEvent(DecathlonEvents event, Double result) {
        double coefficientC = event.getCoefficientC();
        double coefficientA = event.getCoefficientA();
        double coefficientB = event.getCoefficientB();
        double point = coefficientA * Math.pow((result - coefficientB), coefficientC);
        return (int) Math.round(point);
    }
}
