import org.example.util.ResponseParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseParserTest
{
    @Test
    void testResponseParser()
    {
        String json = """
                {
                  "choices": [
                    {
                      "index": 0,
                      "message": {
                        "role": "assistant",
                        "content": "Hello world",
                        "refusal": null,
                        "annotations": []
                      },
                      "logprobs": null,
                      "finish_reason": "stop"
                    }
                  ]
                }
                """;

        String content = ResponseParser.parseResponse(json);
        assertEquals("Hello world", content);
    }
}