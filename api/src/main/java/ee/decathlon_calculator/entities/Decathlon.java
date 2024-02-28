package ee.decathlon_calculator.entities;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Decathlon {
    private final Sport sport;
    private final float point;
    private final boolean isCalculated;
}
// multiple sport
// points