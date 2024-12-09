package org.ApiReader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Mun_commData {

    public static String Mun_CommDataGetter(String sr_type , String type) {
        StringBuilder response = new StringBuilder();
        try {

            String baseUrl = "https://stage.squareyards.ca/api/getAllAreaMuncCommList";

            String newUrl = baseUrl + "?sr_type=" + sr_type + "&type=" + type;
            URL url = new URL(newUrl);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            int ResponseCode = huc.getResponseCode();
            if (ResponseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + ResponseCode);
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return response.toString();
    }
}
