package com.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static String shortURL(String urlToShort) {
        URL url;
        HttpURLConnection conn;
        BufferedReader br = null;
        String line;
        try {
            url = new URL("http://is.gd/create.php?format=simple&url="
                    + urlToShort);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            if ((line = br.readLine()) != null) {
                return line;
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    
}
