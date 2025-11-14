import org.example.service.OpenAIClient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

public class OpenAISingletonTest
{
    @Test
    void testOpenAISingleton()
    {
        OpenAIClient client1 = OpenAIClient.getInstance();
        OpenAIClient client2 = OpenAIClient.getInstance();
        assertSame(client1, client2);
    }
}