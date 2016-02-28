package meitdog.weatherapp;

import android.app.Fragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class WeatherSourceData {
    private SQLiteDatabase database;
    private MySQLiteHelper sqLiteHelper;
    private Fragment parent;

    public String[] weatherColumns = {
            MySQLiteHelper.KEY_ID,
            MySQLiteHelper.KEY_STATION_NAME,
            MySQLiteHelper.KEY_STATION_POSITION,
            MySQLiteHelper.KEY_TIMESTAMP,
            MySQLiteHelper.KEY_TEMPERATURE,
            MySQLiteHelper.KEY_PRESSURE,
            MySQLiteHelper.KEY_HUMIDITY
    };

    public WeatherSourceData(Fragment parentFragment) {
        parent = parentFragment;
        sqLiteHelper = new MySQLiteHelper(parent.getActivity());
    }

    public void open() throws SQLiteException {
        database = sqLiteHelper.getWritableDatabase();
    }

    public void close () {
        sqLiteHelper.close();
    }

    public Weather createWeather (Integer id, String station_name, String station_pos,
                                  String timestamp, String temp, String pressure, String humidity) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_ID, id);
        values.put(MySQLiteHelper.KEY_STATION_NAME, station_name);
        values.put(MySQLiteHelper.KEY_STATION_POSITION, station_pos);
        values.put(MySQLiteHelper.KEY_TIMESTAMP, timestamp);
        values.put(MySQLiteHelper.KEY_TEMPERATURE, temp);
        values.put(MySQLiteHelper.KEY_PRESSURE, pressure);
        values.put(MySQLiteHelper.KEY_HUMIDITY, humidity);

        long insertId = database.insert(MySQLiteHelper.WEATHER_TABLE, null, values);

        return null;
    }

    public Weather cursorToContact(Cursor cursor) {
        Weather weather = new Weather();

        int keyIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_ID);
        int stationNameIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_STATION_NAME);
        int stationPosIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_STATION_POSITION);
        int timeIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_TIMESTAMP);
        int temperaturIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_TEMPERATURE);
        int pressureIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_PRESSURE);
        int humidityIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_HUMIDITY);

        weather.setId(cursor.getInt(keyIndex));

        return weather;
    }

    public Cursor getWeatherFromAllStations() {
       // Cursor cursor = database.query(MySQLiteHelper.WEATHER_TABLE, weatherColumns, null, null, null, null, null);
        return database.query(MySQLiteHelper.WEATHER_TABLE, weatherColumns, null, null, null, null, null);
    }

    public void deleteAll() {
        database.delete(MySQLiteHelper.WEATHER_TABLE, null, null);
    }
}
