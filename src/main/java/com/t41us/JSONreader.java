package com.t41us;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.HashMap;

public class JSONreader {
    public static void parseSunData(String inputJson, String key) {
        /* this is what a normal response from https://api.sunrise-sunset.org/json looks like, with param "formatted=0"
        {
            "results" :
            {
                "sunrise": "2022-03-24T06:01:52+00:00",
                "sunset": "2022-03-24T18:10:40+00:00",
                "solar_noon": "2022-03-24T12:06:16+00:00",
                "day_length":43728,
                "civil_twilight_begin": "2022-03-24T05:42:15+00:00",
                "civil_twilight_end": "2022-03-24T18:30:16+00:00",
                "nautical_twilight_begin": "2022-03-24T05:18:15+00:00",
                "nautical_twilight_end": "2022-03-24T18:54:17+00:00",
                "astronomical_twilight_begin": "2022-03-24T04:54:14+00:00",
                "astronomical_twilight_end": "2022-03-24T19:18:17+00:00"
            },
            "status": "OK"
        }

        key should be a thing in the results object, ex "sunrise"
        */

        try {
            Object object = JSONValue.parse(inputJson);
            JSONObject jsonObject = (JSONObject) object;
            String status = (String) jsonObject.get("status");
            HashMap<String, String> results;
            results = (HashMap<String, String>) jsonObject.get("results"); //todo make safer somehow something something generify
            System.out.println(results.get(key));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("params: " + "inputJson=" + inputJson + ", key = " + key);
        }
    }

    public static int[] getSunData() {
        /*  wrapper class for parseSunData()
        array format:
                ["sunrise","sunset","solar_noon","day_length","civil_twilight_begin,"civil_twilight_end","nautical_twilight_begin","nautical_twilight_end","astronomical_twilight_begin","astronomical_twilight_end"]
         */
        return new int[1];
    }

    public static void test(String rawJson) {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(rawJson);
        Object results = jsonObject.get("results");
    }
}
