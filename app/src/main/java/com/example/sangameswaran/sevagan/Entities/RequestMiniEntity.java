package com.example.sangameswaran.sevagan.Entities;

/**
 * Created by Sangameswaran on 01-03-2018.
 */

public class RequestMiniEntity {
    String patientName,unitsrequired,location,phone;
    int casetype,bloodgroup;
    double latitude,longitude;

    public RequestMiniEntity() {
    }

    public int getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(int bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public RequestMiniEntity(String patientName, String unitsrequired, String location, String phone, int casetype, double latitude, double longitude) {
        this.patientName = patientName;
        this.unitsrequired = unitsrequired;
        this.location = location;
        this.phone = phone;
        this.casetype = casetype;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getUnitsrequired() {
        return unitsrequired;
    }

    public void setUnitsrequired(String unitsrequired) {
        this.unitsrequired = unitsrequired;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCasetype() {
        return casetype;
    }

    public void setCasetype(int casetype) {
        this.casetype = casetype;
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
