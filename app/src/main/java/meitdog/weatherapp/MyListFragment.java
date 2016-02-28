package meitdog.weatherapp;


import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;

public class MyListFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private SimpleCursorAdapter cursorAdapter = null;

    private Weather weather;
    private WeatherSourceData sourceData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mylistfragment, container, false);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

  /*  @Override
    public void onStart() {
        super.onStart();
        sourceData = new WeatherSourceData(this);
        sourceData.open();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.updateWeather();
    }

    private void updateWeather() {
        Cursor cursor = sourceData.getWeatherFromAllStations();
        cursorAdapter.swapCursor(cursor);
    }

    @Override
    public void onStop() {
        super.onStop();
        sourceData.close();
    }

    public void clearData(){
        sourceData.deleteAll();
        this.updateWeather();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.deleteBtn:
                this.clearData();
                break;

            case R.id.downloadBtn:
                this.getWeatherData();
                break;

            case R.id.updateBtn:
                this.updateWeather();
        }
    }

    private void getWeatherData() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cursor cursor = (Cursor)cursorAdapter.getItem(position);

        weather = sourceData.cursorToContact(cursor);

        weather.getId();
        weather.getStation_name();
        weather.getStation_position();
        weather.getTimestamp();
        weather.getTemp();
        weather.getPressure();
        weather.getHumidity();
    } */
}
