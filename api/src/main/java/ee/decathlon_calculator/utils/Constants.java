package ee.decathlon_calculator.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

    public static final String SESSION_ID_HEADER = "X-Session-Id";

    public static final String UNSUPPORTED_EVENT_TYPE = "Unsupported event type: ";

    public static final String EVENT_NOT_FOUND = "Event not found";

}
