package com.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Main {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        System.out.print("Please enter your GroupMe access token: ");
        Scanner input = new Scanner(System.in);
        String token = input.nextLine();

        System.out.println("Thank you. Your token is: " + token);
        Main http = new Main();

        String url = "https://api.groupme.com/v3/groups?token=" + token;

        System.out.println("Sending HTTP GET request");
        http.getRequest(url);

    }

    // Method to send GET request
    private void getRequest(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //Request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    }
}