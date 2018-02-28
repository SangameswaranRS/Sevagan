package com.example.sangameswaran.sevagan.Entities;

/**
 * Created by Sangameswaran on 01-03-2018.
 */

public class RequestMiniEntity {
    String patientname,unitrequired,location,sevaganId;
    int casetype,bloodgroup;
    double latitude,longitude;

    public RequestMiniEntity() {
    }

    public int getBloodgroup() {
        return bloodgroup;
    }

    public String getSevaganId() {
        return sevaganId;
    }

    public void setSevaganId(String sevaganId) {
        this.sevaganId = sevaganId;
    }

    public void setBloodgroup(int bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public RequestMiniEntity(String patientName, String unitsrequired, String location, String phone, int casetype, double latitude, double longitude) {
        this.patientname = patientName;
        this.unitrequired = unitsrequired;
        this.location = location;
        this.casetype = casetype;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPatientName() {
        return patientname;
    }

    public void setPatientName(String patientName) {
        this.patientname = patientName;
    }

    public String getUnitsrequired() {
        return unitrequired;
    }

    public void setUnitsrequired(String unitsrequired) {
        this.unitrequired = unitsrequired;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
