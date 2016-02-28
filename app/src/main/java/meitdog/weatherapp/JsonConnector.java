package meitdog.weatherapp;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class JsonConnector extends ListFragment implements AdapterView.OnItemClickListener {

    OnArticleSelectedListener mCallback;
    ArrayList<Weather> weatherList = new ArrayList<>();
    String JSONResponseString;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String tag = "onItemClick ";
        Log.d(tag, "item " + position);
        mCallback.onArticleSelected(weatherList.get(position));
    }

    public interface OnArticleSelectedListener{
        void onArticleSelected(Weather weather);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        String tag = "onAttach";
        try{
            mCallback = (OnArticleSelectedListener) activity;
            Log.d(tag, mCallback.toString());
        }catch (ClassCastException e){
            Log.d(tag, e.getMessage());
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        requestJSONData("?sort_by=it_no");
        //createAdapter();
    }



    private void requestJSONData(final String parameters){
        final String TAG = "requestJSONData";
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                String connectionURL = "http://kark.hin.no:8088/d3330log_backend/getTestEquipment" + parameters;
                HttpURLConnection connection;
                URL url;
                try{
                    url = new URL(connectionURL);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestProperty("Content-Type", "text/plain; charset-utf-8");
                    int responseCode = connection.getResponseCode();

                    if(responseCode == HttpURLConnection.HTTP_OK)
                        receiveJSONData(connection.getInputStream());
                    else
                        Log.d(TAG, "HTTP RESPONSE: " + responseCode);
                } catch (IOException e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        try {
            thread.start();
            thread.join();

        } catch (InterruptedException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    private void receiveJSONData(InputStream inputStream){
        String tag = "receiveJSONData";
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String input;

        try{
            while((input = bufferedReader.readLine()) != null)
                stringBuilder.append(input);
            JSONResponseString = stringBuilder.toString();
            createArrayList(JSONResponseString);
        } catch (IOException e){
            Log.d(tag, e.getMessage());
        }
    }

    private void createArrayList(String JSONResponseString){
        Gson gson = new Gson();
        weatherList = new ArrayList<>();
        Weather[] listOfWeather = gson.fromJson(JSONResponseString, Weather[].class);
        for(Weather weather: listOfWeather)
            weatherList.add(weather);
    }
}
