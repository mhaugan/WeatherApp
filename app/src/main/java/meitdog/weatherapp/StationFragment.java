package meitdog.weatherapp;

import android.app.Activity;
import android.app.Fragment;
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
import java.util.Collections;

public class StationFragment extends ListFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    String station1URL = "http://kark.hin.no/~wfa/fag/android/2016/weather/vdata.php?id=1";
    String station2URL = "http://kark.hin.no/~wfa/fag/android/2016/weather/vdata.php?id=2";
    String station3URL = "http://kark.hin.no/~wfa/fag/android/2016/weather/vdata.php?id=3";
    String station4URL = "http://kark.hin.no/~wfa/fag/android/2016/weather/vdata.php?id=4";
    String stationDataURL = "http://kark.hin.no/~wfa/fag/android/2016/weather/vstations.php";

    OnArticleSelectedListener mCallback;
    ArrayList<Weather> weatherArrayList = new ArrayList<>();
    String JSONResponseString;
    WeatherSourceData weatherSourceData;
    WeatherAdapter weatherInstance;


    @Override
    public void onStart() {
        super.onStart();
        requestJSONData("?sort_by=id");
        createAdapter();
        weatherSourceData = new WeatherSourceData(this);
        weatherSourceData.open();
    }

    @Override
    public void onStop() {
        super.onStop();
        weatherSourceData.close();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String tag = "onItemClick ";
        Log.d(tag, "item " + position);
        mCallback.onArticleSelected(weatherArrayList.get(position));
    }

    @Override
    public void onClick(View v) {
/*        switch (v.getId()) {
            case R.id.downloadBtn:
                weatherSourceData.getAllWeather();
                break;

            case R.id.updateBtn:
                weatherSourceData.getAllStations();
                break;

            case R.id.deleteBtn:
                weatherSourceData.deleteAll();
                break;
        }*/
        System.out.println("ON CLICK METHOD");
    }

    private void createAdapter(){
        int layoutID = R.layout.station_fragment;
        weatherInstance = new WeatherAdapter(getActivity(), layoutID, weatherArrayList);

        setListAdapter(weatherInstance);
        getListView().setOnItemClickListener(this);
    }

    public interface OnArticleSelectedListener{
        void onArticleSelected(Weather weather);
    }

    private void requestJSONData(final String parameters){
        final String TAG = "requestJSONData";
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                String connectionURL = stationDataURL + parameters;
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
        weatherArrayList = new ArrayList<>();
        Weather[] listOfStations = gson.fromJson(JSONResponseString, Weather[].class);
        for(Weather weather: listOfStations){
            weatherArrayList.add(weather);
        }
    }
}