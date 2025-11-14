package org.example.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseParser // parse the JSON response
{
    public static String parseResponse(String json)
    {
        JSONObject object = new JSONObject(json);
        JSONArray choices = object.getJSONArray("choices");
        JSONObject firstChoice = choices.getJSONObject(0);
        JSONObject message = firstChoice.getJSONObject("message");
        String content = message.getString("content");

        //System.out.println(firstChoice.toString(4));

        return content;
    }
}

/* reads below
{
  "choices": [
    {
      "index": 0,
      "message": {
        "role": "assistant",
        "content": "...",
        "refusal": null,
        "annotations": []
      },
      "logprobs": null,
      "finish_reason": "stop"
    }
  ]
}
*/