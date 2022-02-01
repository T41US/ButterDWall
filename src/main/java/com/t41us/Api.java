package com.t41us;

import com.github.lbovolini.mapper.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Api {
    static ObjectMapper mapper = new ObjectMapper();
    static OkHttpClient http = new OkHttpClient();

    public static Response sendRequest(HashMap<String, String> args) throws IOException {
        String solarTimeURL = "https://api.sunrise-sunset.org/json?";
        for (Map.Entry<String, String> entry : args.entrySet()) {
            solarTimeURL = solarTimeURL + entry.getKey() + "=" + entry.getValue();
        }
        Request request = new Request.Builder().url(solarTimeURL).build();

        Response response = http.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        System.out.println(response.body().string());
        return response;
    }
}
