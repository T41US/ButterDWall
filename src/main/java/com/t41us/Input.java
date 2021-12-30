package com.t41us;

import java.io.*;
import java.util.StringTokenizer;

/*Stolen from Kattio
* TODO delete this later once I dont needed*/
class Input extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st = new StringTokenizer("");
    private String token;

    // standard input
    public Input() {
        this(System.in, System.out);
    }

    public Input(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    // USACO-style file input
    public Input(String problemName) throws IOException {
        super(new FileWriter(problemName + ".out"));
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }

    private String peek() {
        if (token == null) try {
            while (!st.hasMoreTokens()) {
                String line = r.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            token = st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return token;
    }

    public boolean hasMoreTokens() {
        return peek() != null;
    }

    public String next() {
        String ans = peek();
        token = null;
        return ans;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}
