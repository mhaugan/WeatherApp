package meitdog.weatherapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by meitdog on 28.02.2016.
 */
public class WeatherSourceData {
    private SQLiteDatabase database;
    private MySQLiteHelper sqLiteHelper;

    public WeatherSourceData(Context context) {
        sqLiteHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLiteException {
        database = sqLiteHelper.getWritableDatabase();
    }

    public void close () {
        sqLiteHelper.close();
    }

    public Weather createWeather (String temp, String inflated, String humidity) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_TEMPERATURE, temp);
        values.put(MySQLiteHelper.KEY_INFLATED, inflated);
        values.put(MySQLiteHelper.KEY_HUMIDITY, humidity);

        long insertId = database.insert(MySQLiteHelper.WEATHER_TABLE, null, values);

        Cursor cursor = database.query(MySQLiteHelper.WEATHER_TABLE, null, MySQLiteHelper.KEY_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();


        Weather newWeather = cursorToContact(cursor);

        return newWeather;

    }

    private Weather cursorToContact(Cursor cursor) {
        Weather weather = new Weather();
        return weather;
    }
}
