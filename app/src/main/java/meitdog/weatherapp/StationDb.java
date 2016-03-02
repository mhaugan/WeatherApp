package meitdog.weatherapp;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class StationDb {

    public static final String WEATHER_STATION_TABLE = "StationTable";

    public static final String KEY_ID = "id";
    public static final String KEY_STATION_NAME = "stationName";
    public static final String KEY_STATION_POSITION = "stationPosition";


    private static String CREATE_TABLE_WEATHER_STATION = "CREATE TABLE "
            + WEATHER_STATION_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_STATION_NAME + " TEXT,"
            + KEY_STATION_POSITION + " TEXT," + ")";


    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_WEATHER_STATION);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(WeatherDb.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF IT EXISTS " + WEATHER_STATION_TABLE);
        onCreate(db);
    }

}
