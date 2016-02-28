package meitdog.weatherapp;

import java.util.Date;

public class Weather {

    private int id;
    private String station_name, station_position;
    private Date timestamp;
    private String temp, pressure, humidity;

    public Weather (int id, String station_name, String station_position,
                    Date timestamp, String temp, String pressure, String humidity) {
        this.id = id;
        this.station_name = station_name;
        this.station_position = station_position;
        this.timestamp = timestamp;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Weather () {
        super();
        this.temp = "";
        this.pressure = "";
        this.humidity = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getStation_position() {
        return station_position;
    }

    public void setStation_position(String station_position) {
        this.station_position = station_position;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString () {
        return "ID: " + id + "\nStation name: " + station_name + "\nStation position: " + station_position
               + "\nDateTime: " + timestamp + "Temperature: " + temp + "\nInflated: " + pressure + "\nHumidity" + humidity;
    }
}
