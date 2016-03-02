package meitdog.weatherapp;

import java.util.Date;

public class Weather {

    private Integer id;
    private String name, position;
    private Date timestamp;
    private String station_name, station_position, temperature, pressure,humidity;

    public Weather (int id, String station_name, String station_position,
                    Date timestamp, String temperature, String pressure, String humidity) {
        this.id = id;
        this.station_name = station_name;
        this.station_position = station_position;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Weather (int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;    }

/*
    public Weather () {
        super();
        this.id = -1;
        this.name = "";
        this.position = "";
        this.timestamp = null;
        this.temp = "";
        this.pressure = "";
        this.humidity = "";
    }
*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
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
    /*    @Override
    public String toString () {
        return "ID: " + id + "\nStation name: " + station_name + "\nStation position: " + station_position
               + "\nDateTime: " + timestamp + "\nTemperature: " + temp + "\nInflated: " + pressure + "\nHumidity" + humidity;
    }*/

    @Override
    public String toString () {
        return "\nID: " + id + " name: " + name + " Position: " + position;
    }
}
