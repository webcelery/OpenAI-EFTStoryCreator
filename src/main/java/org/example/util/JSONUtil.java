package org.example.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONUtil
{
    public static List<String> loadCharacterNames() // loads names from eft_characters.json
    {
        JSONObject jsonObject = loadResourceJson();
        List<String> names = new ArrayList<>();

        for (String string : new String[]{"traders", "bosses"}) // keys in the JSON file
        {
            JSONArray jsonArray = jsonObject.optJSONArray(string);

            for (int i = 0; i < jsonArray.length(); i++)
            {
                names.add(jsonArray.getJSONObject(i).getString("name"));
            }
        }
        return names;
    }

    static JSONObject loadResourceJson() // loads eft_characters.json
    {
        try (InputStream resource = JSONUtil.class.getResourceAsStream("/eft_characters.json"))
        {
            String json = new String(resource.readAllBytes(), StandardCharsets.UTF_8);
            return new JSONObject(json);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

/*
 {
  "traders": [
    ...
  ],

  "bosses": [
    ...
  ]
}
*/