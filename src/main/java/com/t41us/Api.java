package com.t41us;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Api {
    static OkHttpClient http = new OkHttpClient();

    public static Response sendSolarRequest() throws IOException {
        return sendSolarRequest(0, 0);
    }

    public static Response sendSolarRequest(double lat, double lng) throws IOException {
        return sendSolarRequest(lat, lng, "");
    }

    public static Response sendSolarRequest(Double lat, Double lng, String date) throws IOException {
        StringBuilder URL = new StringBuilder("https://api.sunrise-sunset.org/json?formatted=0+");
        Map<String,String> args = new HashMap<String,String>();
        args.put("lat", lat.toString());
        args.put("lng", lng.toString());
        args.put("date", date);
        return sendRequest(URL, args);
    }

    public static Response sendRequest(StringBuilder URL, Map<String, String> args) throws IOException {
        for (Map.Entry<String, String> entry : args.entrySet()) {
            URL.append(entry.getKey()).append("=").append(entry.getValue()).append("+");
        }
        Request request = new Request.Builder().url(URL.toString()).build();
        Response response = http.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        System.out.println(Objects.requireNonNull(response.body()).string());
        return response;
    }
}

/*
{"results":{"sunrise":"6:01:52 AM","sunset":"6:10:40 PM","solar_noon":"12:06:16 PM","day_length":"12:08:48","civil_twilight_begin":"5:42:15 AM","civil_twilight_end":"6:30:16 PM","nautical_twilight_begin":"5:18:15 AM","nautical_twilight_end":"6:54:17 PM","astronomical_twilight_begin":"4:54:14 AM","astronomical_twilight_end":"7:18:17 PM"},"status":"OK"}
{"results":{"sunrise":"2022-03-24T06:01:52+00:00","sunset":"2022-03-24T18:10:40+00:00","solar_noon":"2022-03-24T12:06:16+00:00","day_length":43728,"civil_twilight_begin":"2022-03-24T05:42:15+00:00","civil_twilight_end":"2022-03-24T18:30:16+00:00","nautical_twilight_begin":"2022-03-24T05:18:15+00:00","nautical_twilight_end":"2022-03-24T18:54:17+00:00","astronomical_twilight_begin":"2022-03-24T04:54:14+00:00","astronomical_twilight_end":"2022-03-24T19:18:17+00:00"},"status":"OK"}
*/
