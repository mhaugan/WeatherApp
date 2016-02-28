package meitdog.weatherapp;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by meitdog on 28.02.2016.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "WeatherInfo.db";
    private static final int DATABASE_VERSION = 1;

    public static final String WEATHER_TABLE = "WeatherTable";

    public static final String KEY_ID = "id";
    public static final String KEY_TEMPERATURE = "temperature";
    public static final String KEY_INFLATED = "inflated";
    public static final String KEY_HUMIDITY = "humidity";

    private static final String CREATE_TABLE_WEATHER = "CREATE TABLE "
            + WEATHER_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TEMPERATURE
            + " TEXT," + KEY_INFLATED + " TEXT," + KEY_HUMIDITY
            + " TEXT" + ")";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_WEATHER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF IT EXISTS " + WEATHER_TABLE);
        onCreate(db);
    }
}
