package com.example.sangameswaran.sevagan.Entities;

/**
 * Created by Sangameswaran on 01-03-2018.
 */

public class FoodLocationEntity {
    String name;
    double latitude;
    double longitude;

    public FoodLocationEntity(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
