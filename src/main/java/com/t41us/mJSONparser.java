package com.t41us;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class mJSONparser {
    public static void parseJSON(String json) {
        try {
            // Parse JSON string using JSON parser
            JSONParser parser = new JSONParser();
            Object object = parser.parse(json);
            JSONArray array = (JSONArray) object;
            System.out.println("First object:");
            System.out.println(array.get(0));
            // Get JSON object from JSON array.
            JSONObject jsonObject = (JSONObject) array.get(1);
            System.out.println("Second object:");
            System.out.println("Name:" + jsonObject.get("name"));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("you're bad");
        }
    }
}
