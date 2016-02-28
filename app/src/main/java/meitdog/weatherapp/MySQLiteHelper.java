package meitdog.weatherapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "WeatherInfo.db";
    private static final int DATABASE_VERSION = 1;

    public static final String WEATHER_TABLE = "WeatherTable";

    public static final String KEY_ID = "id";
    public static final String KEY_STATION_NAME = "stationName";
    public static final String KEY_STATION_POSITION = "stationPosition";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_TEMPERATURE = "temperature";
    public static final String KEY_PRESSURE = "pressure";
    public static final String KEY_HUMIDITY = "humidity";

    private static final String CREATE_TABLE_WEATHER = "CREATE TABLE "
            + WEATHER_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_STATION_NAME + " TEXT,"
            + KEY_STATION_POSITION + " TEXT,"
            + KEY_TIMESTAMP + " TEXT,"
            + KEY_TEMPERATURE + " TEXT,"
            + KEY_PRESSURE + " TEXT,"
            + KEY_HUMIDITY + " TEXT" + ")";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_WEATHER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DATABASE_NAME, "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF IT EXISTS " + WEATHER_TABLE);
        onCreate(db);
    }
}
