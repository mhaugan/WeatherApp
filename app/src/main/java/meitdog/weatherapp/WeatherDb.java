package meitdog.weatherapp;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class WeatherDb {

    public static final String WEATHER_INFO_TABLE = "WeatherTable";
    public static final String KEY_ID = "id";
    public static final String KEY_STATION_NAME = "stationName";
    public static final String KEY_STATION_POSITION = "stationPosition";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_TEMPERATURE = "temperature";
    public static final String KEY_PRESSURE = "pressure";
    public static final String KEY_HUMIDITY = "humidity";

    private static final String CREATE_TABLE_WEATHER = "CREATE TABLE "
            + WEATHER_INFO_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_STATION_NAME + " TEXT,"
            + KEY_STATION_POSITION + " TEXT,"
            + KEY_TIMESTAMP + " TEXT,"
            + KEY_TEMPERATURE + " TEXT,"
            + KEY_PRESSURE + " TEXT,"
            + KEY_HUMIDITY + " TEXT" + ")";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_WEATHER);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(WeatherDb.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF IT EXISTS " + WEATHER_INFO_TABLE);
        onCreate(db);
    }
}
