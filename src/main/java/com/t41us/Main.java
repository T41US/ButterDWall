package com.t41us;

import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Input in = new Input();
        System.out.println("test");
        Response solarResponse = Api.sendSolarRequest();
        String solarString = solarResponse.message();
        JSONreader.parseSunData(solarString, "sunrise" );
        in.flush();
    }
}
