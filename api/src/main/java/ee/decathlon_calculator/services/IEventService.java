package ee.decathlon_calculator.services;

import java.math.BigDecimal;
public interface IEventService {
    int calculateTrackEventPoints(BigDecimal timeInSeconds, BigDecimal a, BigDecimal b, BigDecimal c);
    int calculateFieldEventPoints(BigDecimal measurement, BigDecimal a, BigDecimal b, BigDecimal c);
}
