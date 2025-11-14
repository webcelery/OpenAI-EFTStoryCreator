import org.example.util.ErrorHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorHandlerTest
{
    @Test
    void testTooManyRequests()
    {
        RuntimeException exception = ErrorHandler.handleResponseCode(429);
        assertEquals("Too many requests.", exception.getMessage());
    }

    @Test
    void testInvalidApiKey()
    {
        RuntimeException exception = ErrorHandler.handleResponseCode(401);
        assertEquals("Invalid API key.", exception.getMessage());
    }

    @Test
    void testServerError()
    {
        RuntimeException exception = ErrorHandler.handleResponseCode(500);
        assertEquals("Server error: 500", exception.getMessage());
    }

    @Test
    void testOtherError()
    {
        RuntimeException exception = ErrorHandler.handleResponseCode(404);
        assertEquals("Error: 404", exception.getMessage());
    }
}