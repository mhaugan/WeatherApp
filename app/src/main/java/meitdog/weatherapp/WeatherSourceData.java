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

    public String[] weatherInfoColumns = {
            WeatherDb.KEY_ID,
            WeatherDb.KEY_STATION_NAME,
            WeatherDb.KEY_STATION_POSITION,
            WeatherDb.KEY_TIMESTAMP,
            WeatherDb.KEY_TEMPERATURE,
            WeatherDb.KEY_PRESSURE,
            WeatherDb.KEY_HUMIDITY
    };

    public String[] weatherStationsColumns = {
            StationDb.KEY_ID,
            StationDb.KEY_STATION_NAME,
            StationDb.KEY_STATION_POSITION
    };

    public WeatherSourceData(Fragment parentFragment) {
        parent = parentFragment;
        sqLiteHelper = new MySQLiteHelper(parent.getActivity());
    }

    public void open() throws SQLiteException {
        //TODO: getReadable
        database = sqLiteHelper.getWritableDatabase();
    }

    public void close () {
        sqLiteHelper.close();
    }

    public Cursor getAllStations() {
        Cursor cursor = database.query(StationDb.WEATHER_STATION_TABLE, weatherStationsColumns, null, null, null, null, null);
        return cursor;
    }

    public Cursor getAllWeather() {
        Cursor cursor = database.query(WeatherDb.WEATHER_INFO_TABLE, weatherInfoColumns, null, null, null, null, null, null);
        return cursor;
    }

    public void deleteAll() {
        database.delete(WeatherDb.WEATHER_INFO_TABLE, null, null);
        database.delete(StationDb.WEATHER_STATION_TABLE, null, null);
    }

  /*  public boolean getWeather(Integer id, String station_name, String station_pos,
                              String timestamp, String temp, String pressure, String humidity) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_ID, id);
        values.put(MySQLiteHelper.KEY_STATION_NAME, station_name);
        values.put(MySQLiteHelper.KEY_STATION_POSITION, station_pos);
        values.put(MySQLiteHelper.KEY_TIMESTAMP, timestamp);
        values.put(MySQLiteHelper.KEY_TEMPERATURE, temp);
        values.put(MySQLiteHelper.KEY_PRESSURE, pressure);
        values.put(MySQLiteHelper.KEY_HUMIDITY, humidity);

        long insertId = database.insert(MySQLiteHelper.WEATHER_INFO_TABLE, null, values);

        return true;
    }*/

 /*   public Weather cursorToContact(Cursor cursor) {
        Weather weather = new Weather();

        int keyIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_ID);
        int stationNameIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_STATION_NAME);
        int stationPosIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_STATION_POSITION);
        int timeIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_TIMESTAMP);
        int temperaturIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_TEMPERATURE);
        int pressureIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_PRESSURE);
        int humidityIndex = cursor.getColumnIndexOrThrow(MySQLiteHelper.KEY_HUMIDITY);

        weather.setId(cursor.getInt(keyIndex));
        weather.setStation_name(cursor.getString(stationNameIndex));
        weather.setStation_position(cursor.getString(stationPosIndex));
//        weather.setTimestamp(cursor.getString(timeIndex));
        weather.setTemp(cursor.getString(temperaturIndex));
        weather.setPressure(cursor.getString(pressureIndex));
        weather.setHumidity(cursor.getString(humidityIndex));

        return weather;
    }
*/
}
