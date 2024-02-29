package ee.decathlon_calculator.services;

import java.math.BigDecimal;

public class EventService implements IEventService{
    @Override
    public int calculateTrackEventPoints(BigDecimal timeInSeconds, BigDecimal a, BigDecimal b, BigDecimal c) {
        return 0;
    }

    @Override
    public int calculateFieldEventPoints(BigDecimal measurement, BigDecimal a, BigDecimal b, BigDecimal c) {
        return 0;
    }
}
