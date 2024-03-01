package ee.decathlon_calculator.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

    public static final String SESSION_ID_HEADER = "X-Session-Id";
    public static final String COEFFICIENT_NOT_FOUND = "Coefficient not found";

    public static final String FAILED_TO_CALCULATE_EVENT = "Failed to calculate event";

    public static final String UNSUPPORTED_EVENT_TYPE = "Unsupported event type: ";

    public static final String EVENT_NOT_FOUND = "Event not found";

}
