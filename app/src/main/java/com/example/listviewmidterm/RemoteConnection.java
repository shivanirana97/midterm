package com.example.listviewmidterm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
public class RemoteConnection {
    public String remoteInstance(String s) throws IOException {
        URL u = null;
        try {
            u = new URL(s);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection instanceConnection = null;
        try {
            instanceConnection = (HttpURLConnection) u.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        instanceConnection.setRequestMethod("GET");
        InputStream in = null;
        try {
            in = new BufferedInputStream(instanceConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append('\n');
        }
        in.close();
        return sb.toString();
    }
}
