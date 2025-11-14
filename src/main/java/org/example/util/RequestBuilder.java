package org.example.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class RequestBuilder // builds the JSON body for chat request
{
    public static String chatRequest(String instruction, String prompt, String model, int maxTokens)
    {
        JSONObject body = new JSONObject();
        body.put("model", model);
        body.put("max_tokens", maxTokens);

        JSONArray messages = new JSONArray()
                .put(new JSONObject().put("role", "system").put("content", instruction))
                .put(new JSONObject().put("role", "user").put("content", prompt));

        body.put("messages", messages);

        // System.out.println(body.toString(2));

        return body.toString();
    }
}

/* creates below
{
  "max_tokens": 500,
  "messages": [
    {
      "role": "system",
      "content": "..."
    },
    {
      "role": "user",
      "content": "..."
    }
  ]
}
*/