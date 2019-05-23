package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Currents {
    private final String apikey = "QkgcXMt6_1Ho5a399U98udb2Yu-McknnRSsB_LuxXPwIeecE";
    private final String currentnews = "https://api.currentsapi.services/v1/search?type=1&language=en";

    private ArrayList<String> listoftitles = new ArrayList<>();
    private ArrayList<String> listofdescs = new ArrayList<>();

    public ArrayList<String> getListoftitles(){
        return listoftitles;
    }

    public ArrayList<String> getListofdescs(){
        return listofdescs;
    }


    public void printCurrents() throws IOException {
        BufferedReader br = null;

        try {
            URL url = new URL(currentnews);

            HttpURLConnection myURLConnection = (HttpURLConnection)url.openConnection();

            myURLConnection.setRequestProperty("Authorization",apikey);

            br = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());

            }

            JSONObject obj = new JSONObject(sb.toString());
            JSONArray arr = obj.getJSONArray("news");
            for (int i = 0; i < 5; i++){
                JSONObject subobj = arr.getJSONObject(i);
                String t = subobj.getString("title");
                String d = subobj.getString("description");
                listoftitles.add(t);
                listofdescs.add(d);

            }


        } finally {

            if (br != null) {
                br.close();

            }
        }
    }

}
