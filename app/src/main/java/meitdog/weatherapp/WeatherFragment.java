package meitdog.weatherapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherFragment extends Fragment {
    Weather weather;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.weather_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void showDetail(Weather weather){
        this.weather = weather;
        View view = getActivity().findViewById(R.id._id);

        ((TextView)view.findViewById(R.id._id)).setText(weather.getId());
        ((TextView)view.findViewById(R.id.station_name)).setText(weather.getStation_name());
        ((TextView)view.findViewById(R.id.station_position)).setText(weather.getStation_position());
        ((TextView)view.findViewById(R.id.timestamp)).setText((CharSequence) weather.getTimestamp());
        ((TextView)view.findViewById(R.id.temperature)).setText(weather.getTemperature());
        ((TextView)view.findViewById(R.id.pressure)).setText(weather.getPressure());
        ((TextView)view.findViewById(R.id.humidity)).setText(weather.getHumidity());
    }
}
