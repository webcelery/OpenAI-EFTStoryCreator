import org.example.util.JSONUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JSONUtilTest
{
    @Test
    void testCharacterNames()
    {
        assertTrue(JSONUtil.loadCharacterNames().contains("Prapor"));
        assertTrue(JSONUtil.loadCharacterNames().contains("Tagilla"));

        assertFalse(JSONUtil.loadCharacterNames().isEmpty());
        assertFalse(JSONUtil.loadCharacterNames().contains("Superman"));
    }
}