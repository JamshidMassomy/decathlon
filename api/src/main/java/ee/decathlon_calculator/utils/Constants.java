package ee.decathlon_calculator.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
    public static final String SESSION_ID_HEADER = "X-Session-Id";
    public static final String COEFFICIENT_NOT_FOUND = "Coefficient not found";
}
