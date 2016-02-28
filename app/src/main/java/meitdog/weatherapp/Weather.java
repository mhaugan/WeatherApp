package meitdog.weatherapp;

/**
 * Created by meitdog on 28.02.2016.
 */
public class Weather {
    private String temp, inflated, humidity;

    public Weather (String temp, String inflated, String humidity) {
        this.temp = temp;
        this.inflated = inflated;
        this.humidity = humidity;
    }

    public Weather () {
        super();
        this.temp = "";
        this.inflated = "";
        this.humidity = "";
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getInflated() {
        return inflated;
    }

    public void setInflated(String inflated) {
        this.inflated = inflated;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString () {
        return "Temperature: " + temp + "\nInflated: " + inflated + "\nHumidity" + humidity;
    }
}
