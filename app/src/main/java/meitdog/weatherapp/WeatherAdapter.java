package meitdog.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WeatherAdapter extends ArrayAdapter<Weather>{
    List<Weather> items;
    Context context;

    public WeatherAdapter(Context context, int resource, List<Weather> objects){
        super(context, resource, objects);
        this.context = context;
        this.items = objects;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.station_fragment, parent, false);
        }

        setDataFields(position, convertView);
        return convertView;

    }

    private void setDataFields(int position, View view){
        TextView itemNumberText = (TextView) view.findViewById(R.id._id);
        itemNumberText.setText("" + items.get(position).getId());

        TextView itemBrandText = (TextView) view.findViewById(R.id._name);
        itemBrandText.setText(items.get(position).getName());

        TextView itemModelText = (TextView) view.findViewById(R.id._position);
        itemModelText.setText(items.get(position).getPosition());
    }
}
