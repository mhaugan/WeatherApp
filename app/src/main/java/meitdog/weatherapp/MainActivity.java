package meitdog.weatherapp;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

import java.net.CookieHandler;
import java.net.CookieManager;

public class MainActivity extends AppCompatActivity implements StationFragment.OnArticleSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onArticleSelected(Weather weather){
        WeatherFragment detailFragment = new WeatherFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        FrameLayout detailFrame = (FrameLayout)findViewById(R.id.weather_fragment);

        if(detailFrame.getVisibility() == View.GONE)
            detailFrame.setVisibility(View.VISIBLE);

        transaction.replace(R.id.weather_fragment, detailFragment);
        transaction.commit();
        getFragmentManager().executePendingTransactions();
        detailFragment.showDetail(weather);
    }
}