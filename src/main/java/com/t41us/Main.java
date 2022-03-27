package com.t41us;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Input in = new Input();
        System.out.println("test");
        String stdout = "";
        Process cmdProc = Runtime.getRuntime().exec("pwd");
        BufferedReader stdoutReader = new BufferedReader(
                new InputStreamReader(cmdProc.getInputStream()));
        String line;
        while ((line = stdoutReader.readLine()) != null) {
           stdout += line;
        }
        System.out.println(stdout);
//        JSONreader.parseSunData();
        in.flush();
    }
}
