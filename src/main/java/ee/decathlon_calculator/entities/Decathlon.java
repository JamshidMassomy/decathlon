package ee.decathlon_calculator.entities;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Decathlon {
    private final Sport sport;
    private final float result;
    private final boolean isCalculated;
}
