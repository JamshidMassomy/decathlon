package ee.decathlon_calculator.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class DecathlonEventsExceptionTest {

    @Test
    void testConstructorWithoutMessage() {
        BusinessException exception = new BusinessException();
        assertNull(exception.getMessage());
    }

    @Test
    void testConstructorWithMessage() {
        String message = "Test Message";
        BusinessException exception = new BusinessException(message);
        assertEquals(message, exception.getMessage());
    }
}
